<!DOCTYPE html>
<html>
<head>
    <title>Exhibitions page</title>
    <style>
        /* Ваш CSS здесь */
        body {
            font-family: "Century Gothic"; /* Используйте современный шрифт */
            margin: 0;
            padding: 0;
            background-color: #f4f4f4; /* Добавьте светлый фон */
        }
        .header {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* Добавьте тень для выделения */
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
        }
        .navbar {
            display: flex;
            align-items: center; /* Выравнивание элементов по вертикали */
        }
        .navbar a {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            padding: 10px 20px;
            text-decoration: none;
            color: black;
            border: 1px solid black;
            border-radius: 5px;
            width: 100px;
            height: 50px;
        }
        .navbar img {
            width: 50px;
            height: 50px;
        }
        .exhibition-info {
            background-color: #fff; /* Добавьте белый фон для информации о выставке */
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* Добавьте тень для выделения */
        }
        .exhibition-info img {
            width: 200px;
            height: auto;
            border-radius: 50%; /* Делает изображение выставки круглым */
        }
        .exhibition-details {
            display: flex;
            align-items: flex-start; /* Измените выравнивание элементов на начало */
            justify-content: space-between;
        }
        .register-button {
            background-color: goldenrod; /* Зеленый */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            float: right; /* Добавьте это, чтобы переместить кнопку вправо */
        }
        .message {
            text-align: center; /* Выравнивание текста по центру */
            font-size: 20px; /* Увеличение размера шрифта */
            color: red; /* Изменение цвета текста на красный */
        }
        #logo-block {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 20px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            position: static;
            bottom: 0;
            left: 0;
            right: 0;
        }

        #logo-block img {
            margin-right: 10px;
            max-width: 100px; /* Устанавливает максимальную ширину изображения */
            max-height: 100px;
        }

        #logo-block h2 {
            color: white;
            margin: 0;
            padding: 0;
        }

        #logo-block p {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Exhibitions page</h1>
    <div class="navbar">
        <a href="/online-gallery/profile">
            <img src="/online-gallery/resources/images/service/profile.png" alt="profile">
        </a>
        <a href="/online-gallery/gallery">Gallery</a>
    </div>
</div>
<#if message??>
    <div class="message">${message}</div>
</#if>
<#list exhibitions as exhibition>
    <div class="exhibition-info">
        <h2>${exhibition.name}</h2>
        <div class="exhibition-details">
            <div style="display: flex; align-items: center;">
                <img src="/online-gallery/resources/images/exhibitions/${exhibition.exhibitionId}.jpg" alt="${exhibition.name}" style="margin-right: 20px;">
                <div>
                    <p>Name: ${exhibition.name}</p>
                    <p>Start date: ${exhibition.startDate}</p>
                    <p>End date: ${exhibition.endDate}</p>
                </div>
            </div>
            <button class="register-button" onclick="location.href='/online-gallery/exhibitions?exhibitionId=${exhibition.exhibitionId}'">Sign up for the exhibition</button>
        </div>
    </div>
</#list>

<div id="logo-block">
    <img src="/online-gallery/resources/images/logo.jpg" alt="logo">
    <div>
        <h2><span style="color: goldenrod;">21st</span> century gallery</h2>
        <p>city of Kazan</p>
    </div>
</div>
</body>
</html>
