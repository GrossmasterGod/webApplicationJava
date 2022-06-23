<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 18.06.2022
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Confirm</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<table>
    <tr>
        <th>Price</th>
        <th>Bed Quantity</th>
        <th>Category</th>
    </tr>
    <tr>
        <th>${room.price}</th>
        <th>${room.quantity}</th>
        <th>${room.category}</th>
    </tr>
</table>
<form method="post" action="<c:url value='/addPayment'/>">
    <input type="number" hidden name="room_id" value="${room.id}" />
    <input type="number" hidden name="price" value="${room.price}" />
    <input type="number" hidden name="client_id" value="${user.id}" />
    <input type="submit" name="submit" value="Submit"/>
</form>
</body>
</html>
