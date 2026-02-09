const API_KEY = '54564c49-a647-4324-8f4e-9d6c0c32dada';
const SPN = '0.2,0.1';
const LL = '59.0121,53.4076';

const searchInput = document.getElementById('searchInput');
const resultsContainer = document.getElementById('results');

let debounceTimer;
let currentRequestController = null;

let selectedIndex = -1;
let results = [];

function init() {
    searchInput.addEventListener('input', handleInput);

    searchInput.addEventListener('keydown', handleKeyDown);

    document.addEventListener('click', (e) => {
        if (!searchInput.contains(e.target) && !resultsContainer.contains(e.target)) {
            hideResults();
        }
    });
}

function handleInput() {
    const query = searchInput.value.trim();

    clearTimeout(debounceTimer);

    if (!query) {
        hideResults();
        return;
    }

    debounceTimer = setTimeout(() => {
        searchAddress(query);
    }, 300);
}

async function searchAddress(query) {
    if (currentRequestController) {
        currentRequestController.abort();
    }

    currentRequestController = new AbortController();

    showLoading();

    try {
        const url = `https://suggest-maps.yandex.ru/v1/suggest?apikey=${API_KEY}&text=${encodeURIComponent(query)}&print_address=1&spn=${SPN}&ll=${LL}`;

        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Accept': 'application/json'
            },
            signal: currentRequestController.signal
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        processResults(data);

    } catch (error) {
        if (error.name === 'AbortError') {
            console.log('Запрос отменен');
            return;
        }

        console.error('Ошибка при поиске:', error);
        showError('Ошибка при поиске адресов');
    }
}

function processResults(data) {
    results = [];
    selectedIndex = -1;

    if (data.results && data.results.length > 0) {
        results = data.results;
        displayResults(results);
    } else {
        showNoResults();
    }
}

function displayResults(results) {
    if (results.length === 0) {
        showNoResults();
        return;
    }

    let html = '';

    results.forEach((result, index) => {
        const address = result.title.text;
        const location = result.subtitle.text;
        const distance = result.distance?.text || '';

        let displayAddress = address;
        if (result.title.hl && result.title.hl.length > 0) {
            displayAddress = applyHighlight(address, result.title.hl);
        }

        html += `
                    <div class="result-item" data-index="${index}">
                        <div class="address-street">${displayAddress}</div>
                        <div class="address-location">${location}</div>
                    </div>
                `;
    });

    resultsContainer.innerHTML = html;
    resultsContainer.style.display = 'block';

    document.querySelectorAll('.result-item').forEach(item => {
        item.addEventListener('click', () => {
            const index = parseInt(item.dataset.index);
            selectResult(index);
        });

        item.addEventListener('mouseenter', () => {
            selectedIndex = parseInt(item.dataset.index);
            updateSelection();
        });
    });
}

function applyHighlight(text, highlights) {
    const sortedHl = [...highlights].sort((a, b) => b.begin - a.begin);

    let result = text;
    sortedHl.forEach(hl => {
        const before = result.substring(0, hl.begin);
        const highlighted = result.substring(hl.begin, hl.end);
        const after = result.substring(hl.end);
        result = `${before}<span class="highlight">${highlighted}</span>${after}`;
    });

    return result;
}

function showLoading() {
    resultsContainer.innerHTML = '<div class="loading">Поиск адресов...</div>';
    resultsContainer.style.display = 'block';
}

function showNoResults() {
    resultsContainer.innerHTML = '<div class="no-results">Адресов не найдено</div>';
    resultsContainer.style.display = 'block';
}

function showError(message) {
    resultsContainer.innerHTML = `<div class="no-results" style="color: #d32f2f;">${message}</div>`;
    resultsContainer.style.display = 'block';
}

function hideResults() {
    resultsContainer.style.display = 'none';
}

function handleKeyDown(e) {
    if (results.length === 0 || resultsContainer.style.display === 'none') {
        return;
    }

    switch (e.key) {
        case 'ArrowDown':
            e.preventDefault();
            selectedIndex = Math.min(selectedIndex + 1, results.length - 1);
            updateSelection();
            break;

        case 'ArrowUp':
            e.preventDefault();
            selectedIndex = Math.max(selectedIndex - 1, 0);
            updateSelection();
            break;

        case 'Enter':
            if (selectedIndex >= 0 && selectedIndex < results.length) {
                e.preventDefault();
                selectResult(selectedIndex);
            }
            break;

        case 'Escape':
            hideResults();
            break;
    }
}

function updateSelection() {
    document.querySelectorAll('.result-item').forEach((item, index) => {
        if (index === selectedIndex) {
            item.classList.add('active');
            item.scrollIntoView({ block: 'nearest' });
        } else {
            item.classList.remove('active');
        }
    });
}

function selectResult(index) {
    if (index >= 0 && index < results.length) {
        const selectedResult = results[index];

        searchInput.value = selectedResult.title.text;

        console.log('Выбран адрес:', {
            address: selectedResult.title.text,
            location: selectedResult.subtitle.text,
            coordinates: selectedResult.geometry?.coordinates
        });

        hideResults();

        searchInput.focus();
    }
}

document.addEventListener('DOMContentLoaded', init);