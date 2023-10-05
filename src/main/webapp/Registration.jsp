<%--
  Created by IntelliJ IDEA.
  User: doosuur
  Date: 05.10.2023
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login & Signup Form</title>
    <link rel="stylesheet" href="main.css" />
</head>
<body>
<section class="wrapper">
    <div class="form login">
        <header>Login</header>
        <form action="#">
            <input type="text" placeholder="Email address" required />
            <input type="password" placeholder="Password" required />
            <a href="#">Forgot password?</a>
            <input type="submit" value="Login" />
        </form>
    </div>
    <script>
        const wrapper = document.querySelector(".wrapper"),
            signupHeader = document.querySelector(".signup header"),
            loginHeader = document.querySelector(".login header");
        loginHeader.addEventListener("click", () => {
            wrapper.classList.add("active");
        });
        signupHeader.addEventListener("click", () => {
            wrapper.classList.remove("active");
        });
    </script>
</section>

</body>
</html>
