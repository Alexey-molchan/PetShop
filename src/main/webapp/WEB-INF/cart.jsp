<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All available items</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<a href="/login" style="float: right;"> Logout </a>
<h3>Your order has been accepted and will be processed shortly</h3>
<p>Ordered items:</p>
<table>
    <tr>
        <th>Items name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="goods" items="${cartList}">
        <tr>
            <td>${goods.goodsName}</td>
            <td>${goods.goodsPrice}</td>
        </tr>
    </c:forEach>
</table>
<p>Total amount: ${sum}</p>
<form action="orderall" method="POST">
    <input type="hidden" placeholder="userId" name="userId" value="${userId}">
    <button type="submit">Order all and pay now!</button>
</form>
</body>
</html>