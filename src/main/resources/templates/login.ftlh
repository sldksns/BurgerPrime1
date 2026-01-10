<!DOCTYPE html>
<html>
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
<body>
    <main class="flex bg-[url(../static/img/login_bg.png)] justify-start items-center h-240 w-full mx-auto pt-40 ">
        <div class="border-4 border-zinc-400 bg-zinc-200 rounded-xl mb-45 h-200 w-200 rounded-lg ml-250">
            <img class="h-60 w-60 top-10 left-320 absolute" src="../static/img/logo.png">
            <p class="text-center font-bold mt-43 text-4xl">ВХОД</p>
            <form action="/login" method="post" class="pt-10 w-200 h-125 grid justify-center">
                <p class="ml-20 font-bold text-xl">Имя:</p>
                <input name="name" type="text" class="w-100 ml-20 pl-2 bg-zinc-200 text-xl border-b-4 h-10 " placeholder="Введите имя">
                <p class="ml-20 font-bold text-xl">Пароль:</p>
                <input name="password" type="password" class="ml-20 w-100 text-xl bg-zinc-200 pl-2 h-10 border-b-4  " placeholder="Введите пароль">
                <button type="submit" class="hover:cursor-pointer bg-[#542d2d] ml-20 text-white text-xl text-stone-800 mt-2 rounded border h-10 w-100">Войти</button>
                <p class="ml-5 font-bold text-xl">Если еще не зарегистрированны:<a href="/registration" class="text-[#34a615] hover:cursor-pointer"> Зарегистрироваться</a></p>
            <p class="ml-40 font-bold text-xl">Есть вопросы? <a class="text-[#34a615] hover:cursor-pointer" href="mailto:sasha.mamontov.2008@gmail.com">Задать</a></p>
            </form>
        </div>
    </main>
</body>
</html>