<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<h2>Hello ${name}</h2>
<form action="userinfo" method="POST">
    <input type="hidden" placeholder="Login" name="login" value="${login}">
    <button type="submit" class="items">Get info</button>
</form>
<h2>Items in stock</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Country</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach var="items" items="${itemsAll}">
        <tr>
            <td>${items.itemsName}</td>
            <td>${items.itemsPrice}</td>
            <td>${items.description}</td>
            <td>${items.country}</td>
            <td>  <img src="<s:url value="/images/${items.itemsImage}.jpg" />" /></td>
            <td><form action="orderitem" method="POST">
                <input type="hidden" placeholder="login" name="login" value="${login}">
                <input type="hidden" placeholder="idItems" name="idItems" value="${goods.idGoods}">
                <button type="submit">Add</button>
            </form></td>
        </tr>
    </c:forEach>
</table>
<form action="cart" method="POST">
    <input type="hidden" placeholder="userId" name="userId" value="${userId}">
    <button type="submit">View cart with ordered items</button>
</form>
</body>
</html>