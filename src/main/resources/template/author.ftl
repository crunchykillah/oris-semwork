<!DOCTYPE html>
<html>
<head>
    <title>Author page</title>
    <style>
        body {
            font-family: "Century Gothic"; /* Используйте современный шрифт */
            margin: 0;
            padding: 0;
            background-color: #f4f4f4; /* Добавьте светлый фон */
        }
        #author-info {
            background-color: #fff; /* Добавьте белый фон для информации об авторе */
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* Добавьте тень для выделения */
        }
        #author-info img {
            width: 200px;
            height: auto;
            border-radius: 50%; /* Делает изображение автора круглым */
        }
        .author-details {
            display: flex;
            align-items: flex-start; /* Измените выравнивание элементов на начало */
            justify-content: space-between;
        }
        .navbar {
            display: flex;
            gap: 10px;
        }
        .navbar a {
            text-decoration: none;
            color: black;
            padding: 10px 20px;
            border: 1px solid black;
            border-radius: 5px;
        }
        .gallery {
            display: flex;
            flex-wrap: wrap; /* Позволяет элементам переноситься на новую строку */
            justify-content: space-around; /* Распределяет элементы равномерно по горизонтали с равными промежутками между ними */
        }
        .gallery .item {
            background-color: #fff;
            margin: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            flex-basis: calc(33.33% - 20px); /* Элементы занимают треть строки, но учитывают отступы */
        }
        .gallery .item img {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
        }
        .gallery .item h2 {
            margin: 0 0 10px; /* Добавьте отступ снизу для заголовка */
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
<div id="author-info">
    <h2>Information about author: </h2>
    <div class="author-details">
        <div style="display: flex; align-items: center;">
            <img src="/online-gallery/resources/images/authors/${author.authorId}.jpg" alt="${author.name}" style="margin-right: 20px;">
            <div>
                <p>Name: ${author.name}</p>
                <p>Birth date: ${author.birthDate}</p>
                <p>Death date: ${author.deathDate}</p>
            </div>
        </div>
        <div class="navbar">
            <a href="/online-gallery/gallery">Gallery</a>
            <a href="/online-gallery/exhibitions">Exhibitions</a>
        </div>
    </div>
</div>

<div class="gallery">
    <#list artworks as artwork>
        <div class="item">
            <img src="/online-gallery/resources/images/artworks/${artwork.artworkId}.jpg" alt="${artwork.title}">
            <h2>${artwork.title}</h2>
            <p>Creation year: ${artwork.creationYear}</p>
        </div>
    </#list>
</div>

<div id="logo-block">
    <img src="/online-gallery/resources/images/logo.jpg" alt="logo">
    <div>
        <h2><span style="color: goldenrod;">21st</span> century gallery</h2>
        <p>city of Kazan</p>
    </div>
</div>
</body>
</html>
