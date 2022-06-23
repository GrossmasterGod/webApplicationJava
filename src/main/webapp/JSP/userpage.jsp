<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 15.06.2022
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Userpage</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<h1>Userpage</h1>
<c:choose>
    <c:when test="${user.role.equals('client')}">
        <a href="/user?action=application">Send Application</a>
        <br>
        <c:if test="${applyCheck == true}">
            <a href="/user?action=confirm">Confirm</a>
        </c:if>
        <br>
    </c:when>
    <c:when test="${user.role.equals('manager')}">
        <a href="/review">Review Applications</a>
    </c:when>
</c:choose>
<br>
<a href="/user?action=exit">Exit</a>

</body>
</html>
