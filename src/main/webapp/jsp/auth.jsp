<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Document</title>
    <link rel="stylesheet" href="css/auth.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!--<script src="js/auth.js"></script>-->

    
</head>

<body >

    <header>
        <h1 style="top: 34px;  height: 30px; bottom: 0px; text-align: center">Авторизация</h1>
        <hr size="3px" width="350px" align="center" color="black" style="margin-bottom: 40px">
    </header>


    <section>
        <form action="auth" method="post" modelAttribute="user">
            <input id="inputLogin" name="login" path="login" class="elmsAuthWind inputAuthProduct" type="text" placeholder="Логин" />
            <input id="inputPassword" name="password" path="password" class="elmsAuthWind inputAuthProduct" type="text" placeholder="Пароль" />

            <!--<a id="btnAuth" href="#" class="elmsAuthWind btnAuth" style="display:none">Вход</a>-->
            <input id="btnAuth" class="elmsAuthWind btnAuth" type="submit" value="Вход"/>
            <p style="text-align: center;">${errorMsg}</p>
        </form>

    </section>


    <footer>
            <a id="btnRegister" href="register" style="margin: 100px 43%; ">Зарегистрироваться</a>
    </footer>



</body>

</html>

