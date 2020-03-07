<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<style>
    p {
        border: 1px solid red;
        padding: 10px;
    }
</style>
<body>
<h1>Registration page</h1>
<p>Please fill in this form to create an account.</p>
<form action="checkregistartion" method="POST">
    <label for="name"><b>Name </b></label>
    <input title="Enter your name and lastname" type="text" type="text" placeholder="Your name and lastname" name="name" required>
    <p></p>
    <label for="login"><b>Login </b></label>
    <input title="Your login" type="text" type="text" placeholder="Your login" name="login" required>
    <p></p>
    <label for="age"><b>Age </b></label>
    <input type="number" min="18" max="120" placeholder="your age" name="age" required>
    <p></p>
    <label for="email"><b>Email </b></label>
    <input title="Contact's email (format: jvm@stackover.flow)" type="text" pattern = "[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*" placeholder="jvm@stackover.flow" name="email" required>
    <p></p>
    <label for="password"><b>Password </b></label>
    <input type="password" placeholder="Your strong password" name="password" required>
    <p></p>
    <label for="pswRepeat"><b>Repeat Password </b></label>
    <input type="password" placeholder="Repeat your password" name="pswRepeat" required>
    <p></p>
    <button type="submit">Register</button>
</form>
<p>Already have an account? <a href="login">Sign in</a>.</p>
</body>
</html>