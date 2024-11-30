<!DOCTYPE html>
<html>
<head>
    <title>Login to gallery</title>
    <meta charset="utf-8"/>
    <style>
        body {
            font-family: "Century Gothic";
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        h1 {
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        #message h2 {
            color: red;
        }
        form {
            background-color: #fff;
            padding: 20px;
            margin: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        table {
            margin:  auto;
            font-size: 18px;
        }
        label {
            margin-right: 10px;
        }
        input[type="text"], input[type="password"] {
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
        .signup-button {
            padding: 10px 20px; /* Возвращено к прежнему значению */
            border: none;
            background-color: goldenrod;
            color: white;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            font-size: 14px; /* Возвращено к прежнему значению */
        }
        div {
            text-align: center;
            margin: 20px;
        }
        a {
            color: blue;
            text-decoration: none;
        }
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

        #logo-block img {
            margin-right: 10px;
            max-width: 100px; /* Устанавливает максимальную ширину изображения */
            max-height: 100px;
        }

        #logo-block h2 {
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
<div style="position: relative;">
    <h1 style="text-align: left;"><span style="color: gold;">21st</span> century gallery
        <div style="position: absolute; top: 0; right: 0;">
            <a href="/online-gallery/registration"><button type="button" class="signup-button">Register</button></a>
        </div>
    </h1>
</div>

<div id = "message"><h2>${message}</h2></div>
<form method="post" action="/online-gallery/usercheck">
    <table>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="username" placeholder="enter username"></td>
        </tr>
        <tr>
            <td><label>Password: </label></td>
            <td><input type="password" name="password" placeholder="enter password"></td>
        </tr>
    </table>
    <div><input type="submit" value="sign in"></div>
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
