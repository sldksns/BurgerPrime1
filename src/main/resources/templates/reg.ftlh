<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <link rel="icon" href="../static/img/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    <title>BurgerPrime</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        @font-face {
            font-family: 'Lato';
            src: url("../static/fonts/Lato-Regular.ttf") format("ttf");
        }
        @font-face {
            font-family: 'Montserrat';
            src: url("../static/fonts/Montserrat-Regular.ttf") format("ttf");
        }
        body {
            font-family: 'Lato', sans-serif;
        }
    </style>
</head>
<body class=" text-zinc-800 w-full">
    <main class="flex bg-[url(../static/img/login_bg.png)] justify-start items-center h-240 w-full mx-auto pt-40 ">
        <div class="border-4 border-zinc-400 bg-zinc-200 bg-opacity-50 rounded-xl mb-45 h-200 w-200 rounded-lg bg-opacity-50 ml-25">
            <img class="h-60 w-60 top-7 left-95 absolute" src="../static/img/logo.png">
            <p class="text-center font-bold mt-40 text-4xl">РЕГИСТРАЦИЯ</p>
            <form action="/registration" method="post" class="pt-5 w-200 h-125 grid justify-center">
                <p class="font-bold text-xl">Имя:</p>
                <input name="name" class="w- border-b h-10" placeholder="Введите имя">
                <p class="font-bold text-xl">Пароль:</p>
                <input name="password" class="w-100 h-10 border-b  " placeholder="Введите пароль">
                <button type="submit" class="bg-[#542d2d] text-white text-xl text-stone-800 mt-2 rounded border h-10 w-100">Зарегистрироваться</button>
                <p class="ml-3.5 font-bold text-xl">Если уже зарегистрированны:<a href="/login" class="text-[#34a615] hover:cursor-pointer"> Войти</a></p>
                <#if errorMessage??>
                    <h2 class="ml-3.5 mb-10 text-red-500 font-bold text-xl">${errorMessage}</h2>
                </#if>
                <a class="text-white bg-[#34a615] ml-25 pt-1 text-center text-xl text-stone-800 rounded border h-10 w-50" href="http://localhost:8080/">На главную</a>
            </form>
        </div>

    </main>
    <footer class="flex bg-neutral-700 text-white justify-around pt-10 pb-10 w-full mx-auto">

        <div class="text-2xl ">
            <p>© 2025</p>
        </div>

        <div class="text-2xl ">
            <p>Contacts:</p>
            <p>+7 999 999 99 99</p>
        </div>
    </footer>
</body>
</html>