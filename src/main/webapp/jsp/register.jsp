<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Document</title>
    <link rel="stylesheet" href="css/register.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<body >

    <header>
        <h1 style="top: 34px;  height: 30px; bottom: 0px; text-align: center">Регистрация</h1>
        <hr size="3px" width="350px" align="center" color="black" style="margin-bottom: 40px">
    </header>

    <section>
     <form id="register_form" action="register" method="post" modelAttribute="user">
        <input name="firstName" id="inputFirstName" autocomplete="off" class="elmsRegisterWind inputRegisterProduct" type="text" placeholder="Имя">
        <input name="lastName" id="inputLastName" autocomplete="off" class="elmsRegisterWind inputRegisterProduct" type="text" placeholder="Фамилия">
        <input name="login" id="inputLogin" autocomplete="off" class="elmsRegisterWind inputRegisterProduct" type="text" placeholder="Логин">
        <input name="password" id="inputPassword" autocomplete="off" class="elmsRegisterWind inputRegisterProduct" type="text" placeholder="Пароль">

        <input id="inputRepeatedPassword" autocomplete="off" class="elmsRegisterWind inputRegisterProduct" type="text" placeholder="Повторить Пароль">
        <p style="margin: 30px 42.5%; display: none">${errorMsg}</p>

        <input id="btnRegister" type="submit" class="elmsRegisterWind btnRegister" value="Зарегистрироваться"/>
     </form>
    </section>


    <footer>
            <a id="btnAuth" href="auth" style="margin: 100px 46%;" class="authStr">Авторизация</a>
    </footer>



</body>
<!--<script src="js/register.js"></script>-->
</html>

