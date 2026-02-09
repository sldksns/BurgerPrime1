const minusButtons = document.querySelectorAll('.minus_button');
const plusButtons = document.querySelectorAll('.plus_button');

minusButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    const product = btn.closest('.product-item');
    const cost = parseInt(product.getAttribute('data-product-cost'), 10);
    if (!product) return;

    let countEl = product.querySelector('.count');
    let count = parseInt(countEl.innerText);

    if (count > 0) {
      count--;
      if (count === 0) {
        product.classList.add('animate-slide-up');

        product.addEventListener('animationend', () => {
          product.remove();
          updateFinalCost();
        }, { once: true });
        const productId = parseInt(product.getAttribute('data-product-id'), 10);
        fetch('/basket/remove_product?productId=' + encodeURIComponent(productId), {
            method: 'POST' // или 'POST', в зависимости от вашего API
        });
      } else {
        countEl.innerText = count;
        const newCost = cost * count;
        product.querySelector('.cost').innerText = newCost + ' руб.';
        updateFinalCost();
      }
    }
  });
});

plusButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    const product = btn.closest('.flex.items-start');
    const countEl = product.querySelector('.count');
    const costEl = product.querySelector('.cost');
    const cost = parseInt(product.getAttribute('data-product-cost'), 10);
    let count = parseInt(countEl.innerText);
    count++;
    countEl.innerText = count;

    const newCost = cost * count;
    costEl.innerText = newCost + ' руб.';

    updateFinalCost();
  });
});

function updateFinalCost() {
  let total = 0;
  document.querySelectorAll('.cost').forEach(el => {
    const costText = el.innerText.replace(' руб.', '');
    total += parseInt(costText);
  });
  document.getElementById('final_cost').innerText = total + ' руб.';
}