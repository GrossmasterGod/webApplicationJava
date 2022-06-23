<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 16.06.2022
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<form method="post" action="user">
    <h2>Application:</h2>

    <label>
        Bed Quantity(from 1 to 3)
        <input type = "number" name = "quantity" min = "1" max="3">
    </label>
    <br>
    <label>
        Category(from 1 to 3)
        <input type = "number" name = "category" min = "1" max = "3">
    </label>
    <br>
    <label>
        Stay time(in days,to 30 days)
        <input type = "number" name = "staying" min = "1" max="30">
    </label>
    <br>
    <input type="hidden" name="action" value="application">
    <button type="submit">Submit</button>
</form>
</body>
</html>
