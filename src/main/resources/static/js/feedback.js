const starsContainer = document.querySelector('.stars');
const stars = Array.from(starsContainer.children);
const ratingInput = document.getElementById('rating');

stars.forEach((star, index) => {
    star.addEventListener('click', () => {
        stars.forEach((s, i) => {
            s.style.color = i <= index ? '#FFC107' : '';
        });
        ratingInput.value = index + 1;
    });
});
