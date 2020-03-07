<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<a href="/login" style="float: right;"> Logout </a>
<h3>Information about user:</h3>
<img src="<s:url value="/images/user.jpg" />" />
<p>Username: ${login}</p>
<p>Name: ${name}</p>
<p>Age: ${age}</p>
<p>E-mail: ${email}</p>
<form action="items" method="POST">
    <input type="hidden" placeholder="Login" name="login" value="${login}">
    <button type="submit">Go to the shop</button>
</form>
</body>
</html>