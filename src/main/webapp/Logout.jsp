<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <style>
        body {
            background-image: url('image/cloth.jpg'); /* Path to your background image */
            background-size: cover; /* Cover the entire viewport */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repetition */
            margin: 0; /* Remove default margin */
            height: 100vh; /* Ensure the body takes the full height of the viewport */
            display: flex; /* Use flexbox for centering */
            justify-content: center; /* Center horizontally */
            align-items: center; /* Center vertically */
            font-family: Arial, sans-serif; /* Set a default font */
            color: white; /* Default text color */
        }

        .container {
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
            padding: 30px; /* Add padding */
            border-radius: 15px; /* Rounded corners */
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); /* Shadow for depth */
            text-align: center; /* Center text */
            max-width: 400px; /* Set a maximum width */
            width: 100%; /* Full width */
        }

        h2 {
            margin-bottom: 20px; /* Space below the heading */
            font-size: 24px; /* Font size for the heading */
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px; /* Padding for input fields */
            border-radius: 5px; /* Rounded corners */
            border: none; /* Remove border */
            width: 100%; /* Full width */
            margin-bottom: 10px; /* Space below input fields */
            font-size: 16px; /* Font size for input */
        }

        input[type="submit"] {
            background-color: rgba(255, 190, 255, 0.7); /* Background color for submit button */
            color: white; /* Text color for submit button */
            border: none; /* Remove border */
            padding: 10px; /* Padding for submit button */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size for submit button */
            transition: background-color 0.3s; /* Smooth transition */
        }

        input[type="submit"]:hover {
            background-color: rgba(255, 100, 255, 0.8); /* Darker shade on hover */
        }

        .msg {
            margin-top: 10px; /* Space above the message */
            color: yellow; /* Color for the message */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            Username: <input type="text" name="username" required><br>
            Password: <input type="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
        <div class="msg">
            <%= request.getAttribute("msg") != null ? request.getAttribute("msg") : "" %>
        </div>
    </div>
</body>
</html>