<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 18.06.2022
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<nav>
    <a href="/MainPage?action=price">Main page</a>
    <c:choose>
        <c:when test="${sessionScope.user == null}">
            <a href="/user?action=registration">Registration</a>
            <a href="/user?action=login">Login</a>
        </c:when>
        <c:otherwise>
            <a href="/user?action=userpage">User page</a>
        </c:otherwise>
    </c:choose>
</nav>
</body>
</html>
