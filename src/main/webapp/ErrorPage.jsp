<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p><%= request.getAttribute("msg") %></p>
    <a href="AdminLogin.html">Go to Login</a>
</body>
</html>