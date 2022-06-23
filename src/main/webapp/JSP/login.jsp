<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 15.06.2022
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<a href="/MainPage?action=price">Main page</a>
<form action="user" method="post">

    <label>
        Username:
    </label>
    <input type="text" name="username" >
    <br>
    <label>
        Password:
    </label>
    <input type="password" name="password" >

    <input type="hidden" name="action" value="login">
    <br>
    <span>${errorMessage}</span>
    <br>
    <button type="submit" class="btn-primary" >Submit</button>
</form>
</body>
</html>
