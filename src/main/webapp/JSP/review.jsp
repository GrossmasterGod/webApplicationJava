<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 16.06.2022
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Review</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<h2>Applications:</h2>
<c:forEach var ="app" items="${requestScope.apps}">
    <ul>
        <li> Id: <c:out value="${app.id}"/></li>
        <li> Client_id:<c:out value="${app.clientId}"/></li>
        <li> Quantity: <c:out value="${app.quantity}"/></li>
        <li> Category: <c:out value="${app.category}"/></li>
        <li> Staying: <c:out value="${app.staying}"/></li>

        <form method="post" action="deleteReview">
            <input type="number" hidden name="id" value="${app.id}" />
            <input type="submit" name="delete" value="Delete"/>
        </form>
    </ul>
    <hr/>
</c:forEach>
<h2>Hotel Rooms:</h2>
<c:forEach var ="room" items="${requestScope.rooms}">
    <ul>
        <li> Id: <c:out value="${room.id}"/></li>
        <li> Ціна: <c:out value="${room.price}"/></li>
        <li> Кількість ліжок: <c:out value="${room.quantity}"/></li>
        <li> Категорія: <c:out value="${room.category}"/></li>
        <li> Статус: <c:out value="${room.status}"/></li>


    </ul>
    <hr />
</c:forEach>
<form action="review" method="post">
<h2>Send a request to user</h2>
    <label>
        Room_id:
    </label>
    <input type="number" name="roomId" min="1" max="6" >
    <label>
        Application_id:
    </label>
    <input type="number" name="appId" >
    <br>
    <button type="submit" class="btn-primary" >Submit</button>
</form>
${applyValid}
</body>
</html>
