<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <style>
        /* Общие стили */
        body {
            font-family: "Century Gothic";
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        /* Стили для блока информации о посетителе */
        #visitor-info {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        /* Стили для навигационной панели */
        #visitor-info .navbar {
            display: flex;
            gap: 10px;
        }
        #visitor-info .navbar a {
            text-decoration: none;
            color: black;
            padding: 10px 20px;
            border: 1px solid black;
            border-radius: 5px;
        }
        /* Стили для блока с выставками */
        .exhibitions {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .exhibitions .item {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #fff;
            margin: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            flex-basis: calc(33.33% - 10px);
        }
        .exhibitions .item img {
            max-width: 400px;
            max-height: 300px;
            height: auto;
            margin-bottom: 10px;
        }
        .exhibitions-header {
            text-align: center;
            width: 100%;
        }
        /* Стили для блока с логотипом */
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
        /* Стили для логотипа */
        #logo-block img {
            margin-right: 10px;
            max-width: 100px;
            max-height: 100px;
        }
        /* Стили для текста в блоке логотипа */
        #logo-block h2,
        #logo-block p {
            margin: 0;
            padding: 0;
        }
    </style>

</head>
<body>
<div id="visitor-info">
    <div>
        <h1>${user.name}</h1>
        <h2>Your login: ${user.username}</h2>
        <h2>Your email: ${user.email}</h2>
    </div>
    <div class="navbar">
        <a href="/online-gallery/gallery">Gallery</a>
        <a href="/online-gallery/exhibitions">Exhibitions</a>
    </div>
</div>
<div class="exhibitions">
    <div class="exhibitions-header">
        <h1>Exhibitions for which you are registered: </h1>
        <#if exhibitions?size == 0>
            <p>No exhibitions found</p>
        </#if>
    </div>
    <#list exhibitions as exhibition>
        <div class="item">
            <img src="/online-gallery/resources/images/exhibitions/${exhibition.exhibitionId}.jpg" alt="Exhibition Image">
            <h2>Exhibition name: ${exhibition.name}</h2>
            <p>Start date: ${exhibition.startDate}</p>
            <p>End date: ${exhibition.endDate}</p>
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

