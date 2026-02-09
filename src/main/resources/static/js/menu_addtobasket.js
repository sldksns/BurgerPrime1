document.querySelectorAll('.plus').forEach(btn => {
    btn.addEventListener('click', () => {
        const productId = parseInt(btn.getAttribute('data-product-id'), 10);

        fetch('/basket/add_product?productId=' + encodeURIComponent(productId), {
            method: 'POST'
        })
            .then(response => {
                if (response.ok) {
                    alert('Товар добавлен в корзину');
                } else {
                    alert('Ошибка при добавлении товара');
                }
            })
            .catch(error => {
                console.error('Ошибка:', error);
                alert('Ошибка при добавлении товара');
            });
    });
});