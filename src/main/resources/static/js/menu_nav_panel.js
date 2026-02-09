const nav_panel = document.getElementById('header_nav');
const elems = nav_panel.children;

for (let i = 0; i < elems.length; i++) {
    elems[i].addEventListener('click', () => {
        for (let j = 0; j < elems.length; j++) {
            elems[j].style.backgroundColor = '';
            elems[j].style.color = '';
        }
        elems[i].style.backgroundColor = '#D5552E';
        elems[i].style.color = '#FFFFFF';
    });
}