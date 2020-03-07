<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Let's login</title>
</head>
<style>
    p {
        border: 1px solid red;
        padding: 10px;
    }
</style>
<body>
<h1>Login page</h1>
<p>Please fill in this form to login in account.</p>
<form action="checklogin" method="POST">
    <label for="login"><b>Login</b></label>
    <input type="text" placeholder="Login" name="login" required>
    <p></p>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <p></p>
    <button type="submit" class="login">Login</button>
</form>
<p>Don't you have an account? <a href="registration">Registration</a></p>
</body>
</html>