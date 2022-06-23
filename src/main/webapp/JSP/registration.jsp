<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 14.06.2022
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<a href="/MainPage?action=price">Main page</a>
<form method="post" action="user">
    <input type="hidden" name="role" value="client">
    <label>
        Name
        <input type = "text" name = "name">
    </label>
    <br>
    <label>
        Login
        <input type = "text" name = "login">
    </label>
    <br>
    <label>
        Password
        <input type = "password" name = "password">
    </label>
    <br>
    <input type="hidden" name="action" value="registration">
    <input type="submit" value="Ok" name = "Ok">

</form>
${registerValidation}
</body>
</html>
