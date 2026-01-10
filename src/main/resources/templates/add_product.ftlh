<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <meta charset="UTF-8" />
        <link rel="icon" href="../static/img/favicon.ico" type="image/x-icon">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
        <title>BurgerPrime</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
</head>
<body class="bg-mainColor text-white bg-zinc-300 w-full">
    <header class="border-b border-white-500 bg-neutral-700 w-full fixed top-0 z-50">
        <div class="flex items-center justify-between px-4 py-3">

            <div class="flex-shrink-0 pr-110 pl-10">
                <a><span class="w-10 h-10"><img src="../static/img/ico.png" alt="Иконка"></span></a>
            </div>

            <div class="flex relative justify-center w-200 h-10 flex-1 mx-4">
                <input class="w-195 cursor-pointer h-10 absolute px-4 border rounded hover:border-stone-800" type="text" placeholder="Поиск товаров" />
                <button type="submit" class="border border-black hover:border-white cursor-pointer absolute ml-174 top-0 h-full px-4 bg-green-300 text-stone-800 rounded-lg">Нажать</button>
            </div>

            <div class="flex items-center space-x-2 flex-shrink-0 pl-95 pr-10">
                <img class="w-10 h-10 rounded-full" src="../static/img/default.png" alt="Пользователь">
                <p class="pt-1 text-xl">Admin</p>
            </div>
        </div>
    </header>
    <main class="flex justify-center items-center w-full mx-auto pt-40">
        <div class="w-350 h-140">
            <form action="/add/product" enctype="multipart/form-data" method="post" class="grid grid-cols-2 bg-neutral-700 w-350 h-130 border border-white border-b border-1 rounded-lg">
                <div class="flex flex-col p-4 space-y-2">
                    <p class="text-2xl text-center">ДОБАВИТЬ ПРОДУКТ</p>
                    <p class="text-xl">Название товара</p>
                    <input name="name" class="pl-2 w-160 mb-1 cursor-pointer border rounded hover:border-stone-800" type="text" placeholder="Название" />

                    <p class="text-xl">Описание</p>
                    <textarea name="description" class="pl-2 w-160 cursor-pointer mb-1 border rounded hover:border-stone-800" rows="5" cols="50" placeholder="Вкус, состав, бжу и тд."></textarea>

                    <p class="text-xl">Категория товара</p>
                    <select name="category" class="text-center cursor-pointer w-80 mb-1 border rounded hover:border-stone-800">
                        <option class="text-black">Основное блюдо</option>
                        <option class="text-black">Дополнительное блюдо</option>
                        <option class="text-black">Напиток</option>
                    </select>



                    <p class="text-xl">Цена</p>
                    <input name="price" class="pl-2 w-160 mt-1 border cursor-pointer rounded hover:border-stone-800" type="number" placeholder="Цена в рублях" />
                    <br>
                </div>

                <div class="flex flex-col items-center justify-start p-4 space-y-2">
                    <p class="text-2xl">ЗАГРУЗИТЬ ИЗОБРАЖЕНИЯ</p>
                    <input name="file1" class="border border-black hover:border-white mt-1 w-70 text-stone-800 cursor-pointer bg-green-300 border border-black rounded" type="file"/>
                    <input name="file2" class="border border-black hover:border-white mt-1 w-70 text-stone-800 cursor-pointer bg-green-300 border border-black rounded" type="file"/>
                    <input name="file3" class="border border-black hover:border-white mt-1 w-70 text-stone-800 cursor-pointer bg-green-300 border border-black rounded" type="file"/>


                </div>
                <button type="submit" class=" mb-5 mr-40 cursor-pointer w-100 bg-green-300 text-stone-800 rounded-lg border border-black hover:border-white ml-auto">Добавить</button>
            </form>
            <a class="flex w-100 text-center justify-center  bg-green-300 hover:border-white ml-125 text-stone-800 rounded border" href="http://localhost:8080/">На главную</a>
        </div>
    </main>
    <footer class="flex bg-neutral-700 text-white justify-around mt-100 pt-10 pb-10 w-full mx-auto">

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