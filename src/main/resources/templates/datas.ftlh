<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Main</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
        <style>
            @font-face {
                font-family: 'MontserratAlternates-Bold';
                src: url("../static/fonts/MontserratAlternates-Bold.ttf") format("truetype");
            }
            @font-face {
                font-family: 'MontserratAlternates-SemiBold';
                src: url("../static/fonts/MontserratAlternates-SemiBold.ttf") format("truetype");
            }
            @font-face {
                font-family: 'MontserratAlternates-Medium';
                src: url("../static/fonts/MontserratAlternates-Medium.ttf") format("truetype");
            }
            @font-face {
                font-family: 'Montserrat-Medium';
                src: url("../static/fonts/Montserrat-Medium.ttf") format("truetype");
            }
            @font-face {
                font-family: 'Montserrat-Bold';
                src: url("../static/fonts/Montserrat-Bold.ttf") format("truetype");
            }
            body {
                font-family: 'MontserratAlternates-SemiBold', sans-serif;
            }
        </style>
    </head>
    <body>
    <header class="flex fixed justify-center items-center h-15 w-full bg-[#D5552E] pt-2 pb-2 space-x-1 rounded-b-[24px] shadow-xl">
        <a href="/profile"><img class="absolute top-[17px] left-[16px]" src="../static/img/reversed_arrow.png" alt=""></a>
        <img class="" src="/static/img/alt_logo 1.png">
        <p class="text-[20px] text-white">BurgerPrime</p>
    </header>
        <main class="flex justify-center bg-[#FFF9EE] h-full min-h-screen w-full pt-15 pb-45">
            <div class="w-[361px] h-full">
                <form class="mt-[32px] space-y-[16px]" action="/account/add_data" method="post">
                    <div class="w-full h-[80px] bg-[#F0E4CB] rounded-[20px] shadow-xl py-[16px] px-[16px] text-[16px]">
                        <label style="font-family: 'MontserratAlternates-Bold';" class="text-[#1D342C]">Отображаемое имя</label>
                        <input name="displayed_name" style="font-family: 'Montserrat-Medium';" class="w-full h-[24px] focus:outline-0" type="text" name="name" placeholder="Укажите имя">
                    </div>
                    <div class="w-full h-[80px] bg-[#F0E4CB] rounded-[20px] shadow-xl py-[16px] px-[16px] text-[16px]">
                        <label style="font-family: 'MontserratAlternates-Bold';" class="text-[#1D342C]">Дата рождения</label>
                        <input name="date_of_birth" style="font-family: 'Montserrat-Medium';" class="w-full h-[24px] focus:outline-0" type="text" name="name" placeholder="Укажите дату рождения">
                    </div>
                    <div class="w-full h-[80px] bg-[#F0E4CB] rounded-[20px] shadow-xl py-[16px] px-[16px] text-[16px]">
                        <label style="font-family: 'MontserratAlternates-Bold';" class="text-[#1D342C]">Пол</label>
                        <select name="gender" style="font-family: 'Montserrat-Medium';" class="w-full h-[24px] focus:outline-0 " type="text" name="name" placeholder="Укажите имя">
                                <option style="font-family: 'Montserrat-Medium';" class="bg-[#F0E4CB]" value="Мужской">Мужской</option>
                                <option style="font-family: 'Montserrat-Medium';" class="bg-[#F0E4CB]" value="Женский">Женский</option>
                                <option style="font-family: 'Montserrat-Medium';" class="bg-[#F0E4CB]" value="Другой">Другой</option>
                        </select>
                    </div>
                    <div class="w-full h-[80px] bg-[#F0E4CB] rounded-[20px] shadow-xl py-[16px] px-[16px] text-[16px]">
                        <label style="font-family: 'MontserratAlternates-Bold';" class="text-[#1D342C]">Телефон</label>
                        <input name="phone_number" style="font-family: 'Montserrat-Medium';" class="w-full h-[24px] focus:outline-0" type="text" name="name" placeholder="Укажите номер телефона">
                    </div>
                    <div class="w-full h-[80px] bg-[#F0E4CB] rounded-[20px] shadow-xl py-[16px] px-[16px] text-[16px]">
                        <label style="font-family: 'MontserratAlternates-Bold';" class="text-[#1D342C]">Эл. почта</label>
                        <input name="email" style="font-family: 'Montserrat-Medium';" class="w-full h-[24px] focus:outline-0" type="text" name="name" placeholder="Укажите дату рождения">
                    </div>
                    <button style="font-family: 'MontserratAlternates-Bold';" class="fixed top-0 right-[32px] h-15 w-[50px] text-center bg-[#D5552E] text-white z-10 text-[16px]">Готово</button>
                </form>
            </div>
        </main>
        <div class="flex justify-around items-center w-full h-15 bg-[#F0E4CB] fixed bottom-1 rounded-t-[16px] shadow-xl">
            <a href="/"><img src="/static/img/main.png" alt=""></a>
            <a href="/menu"><img src="/static/img/menu.png" alt=""></a>
            <a href="/basket"><img src="/static/img/basket.png" alt=""></a>
            <a href="/profile"><img src="/static/img/profile_active.png" alt=""></a>
        </div>
    </body>
</html>