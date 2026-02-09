const password_input = document.getElementById('password_input');
const confirm_password_input = document.getElementById('confirm_password_input');

confirm_password_input.addEventListener('input', () => {
    if (password_input.value !== confirm_password_input.value) {
        confirm_password_input.setCustomValidity('Пароли не совпадают');
    } else {
        confirm_password_input.setCustomValidity('');
    }
});