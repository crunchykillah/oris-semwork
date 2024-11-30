<!DOCTYPE html>
<html>
<head>
    <title>Online-gallery</title>
    <style>
        body {
            font-family: "Century Gothic";
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
        }
        .navbar {
            display: flex; /* Добавляем это свойство */
        }
        .navbar a {
            display: flex;
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
        form {
            display: flex;
            flex-direction: row; /* Изменяем направление контейнера на строку */
            align-items: center; /* Выравнивание элементов по центру */
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin: 20px;
        }
        form label,
        form select,
        form input[type="submit"] {
            margin-right: 10px; /* Добавляем отступы справа между элементами формы */
        }
        form input[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: goldenrod;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        form input[type="submit"]:hover {
            background-color: darkgoldenrod;
        }
        .gallery {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .item {
            background-color: #fff;
            margin: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .item img {
            max-width: 500px;
            height: auto;
            margin-bottom: 10px;
        }
        .item h2 {
            margin: 0 0 10px;
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
            max-width: 100px;
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
    <h1>Online-gallery</h1>
    <div class="navbar">
        <a href="/online-gallery/profile">
            <img src="/online-gallery/resources/images/service/profile.png" alt="profile">
        </a>
        <a href="/online-gallery/exhibitions">Exhibitions</a>
    </div>
</div>

<form action="/online-gallery/gallery" method="get">
    <label for="author">Choose author: </label>
    <select name="author" id="author">
        <option value="">Not chosen</option>
        <#list authors as author>
            <option value="${author.authorId}">${author.name}</option>
        </#list>
    </select>
    <input type="submit" value="Filter">
</form>

<div class="gallery">
    <#list artworks as artwork>
        <div class="item">
            <img src="/online-gallery/resources/images/artworks/${artwork.artworkId}.jpg" alt="${artwork.title}">
            <h2>${artwork.title}</h2>
            <p>Author: <a href="/online-gallery/author?id=${artwork.author.authorId}">${artwork.author.name}</a></p>
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
