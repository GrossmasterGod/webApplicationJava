<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 11.06.2022
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Main Page</h1>

<h2>Rooms</h2>
<h5>Sort by:</h5>
<a href = "MainPage?action=price">Price</a>
<a href = "MainPage?action=quantity">Bed Quantity</a>
<a href = "MainPage?action=category">Category</a>
<a href = "MainPage?action=status">Status</a>

<c:forEach var ="room" items="${requestScope.rooms}">
    <ul>
        <li> Ціна: <c:out value="${room.price}"/></li>
        <li> Кількість ліжок: <c:out value="${room.quantity}"/></li>
        <li> Категорія: <c:out value="${room.category}"/></li>
        <li> Статус: <c:out value="${room.status}"/></li>


    </ul>
    <hr />
</c:forEach>
</body>
</html>
