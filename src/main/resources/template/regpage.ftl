<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8"/>

    <script src='/lab10/resources/js/validate_form.js'></script>

    <style>
        /* Общие стили */
        body {
            font-family: "Century Gothic";
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        /* Стили для раздела заголовка */
        h1 {
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        /* Стили для сообщения об ошибке */
        #message h2 {
            color: red;
        }
        /* Стили для формы */
        form {
            background-color: #fff;
            padding: 20px;
            margin: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        /* Стили для таблицы */
        table {
            margin:  auto;
            font-size: 18px;
        }
        label {
            margin-right: 10px;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="phone"],
        input[type="username"]{
            padding: 20px; /* Увеличено с 10px до 20px */
            border: none;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            font-size: 18px; /* Добавлено для увеличения размера текста */
        }
        input[type="submit"] {
            padding: 20px 40px; /* Увеличено с 10px 20px до 20px 40px */
            border: none;
            background-color: goldenrod;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            font-size: 18px; /* Добавлено для увеличения размера текста */
        }
        input[type="submit"]:hover {
            background-color: darkgoldenrod;
        }
        /* Стили для блока с информацией и ссылкой */
        div {
            text-align: center;
            margin: 20px;
        }
        a {
            color: blue;
            text-decoration: none;
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
            position: fixed;
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
        /* Стили для заголовка логотипа */
        #logo-block h2,
        #logo-block p {
            margin: 0;
            padding: 0;
        }
        .login-button {
            padding: 10px 20px; /* Возвращено к прежнему значению */
            border: none;
            background-color: goldenrod;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            font-size: 14px; /* Возвращено к прежнему значению */
        }
    </style>
</head>
<body>

<div style="position: relative;">
    <h1 style="text-align: left;">Registration
        <div style="position: absolute; top: 0; right: 0;">
            <a href="/online-gallery/login"><button type="button" class="login-button">login</button></a>
        </div>
    </h1>
</div>


<div id="error">${error!" "} </div>
<form method="post" action="/online-gallery/registration" onsubmit="return validate()"> <!-- validate  -->
    <table>
        <tr>
            <td><label>Name: </label></td>
            <td><input type="text" name="name" placeholder="your name" required ></td>
        </tr>
        <tr>
            <td><label>Login: </label></td>
            <td><input type="text" name="username" placeholder="login"></td>
        </tr>
        <tr>
            <td><label>E-mail: </label></td>
            <td><input id="email" type="text" name="email" placeholder="email"></td>
        </tr>
        <tr>
            <td><label>Phone number: </label></td>
            <td><input id="phone" type="text" name="phone" placeholder="+71111111111" ></td>
        </tr>
        <tr>
            <td><label>Password: </label></td>
            <td><input id="pwd" type="password" name="password" placeholder="create a password"></td>
        </tr>
        <tr>
            <td><label>Repeat password: </label></td>
            <td><input id="pwd1" type="password" placeholder="repeat password"></td>
        </tr>
    </table>
    <div>
        <input type="submit" value="sign up">
    </div>
</form>
<div id="logo-block">
    <img src="/online-gallery/resources/images/logo.jpg" alt="logo">
    <div>
        <h2><span style="color: goldenrod;">21st</span> century gallery</h2>
        <p>city of Kazan</p>
    </div>
</div>

</body>
</html>
