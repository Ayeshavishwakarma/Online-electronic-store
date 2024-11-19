<%@ page session="true" %>
<%@ page import="pack1.AdminBean" %>
<%
    AdminBean abean = (AdminBean) session.getAttribute("abean");
    if (abean == null) {
        // Redirect to login if the session attribute is null
        response.sendRedirect("AdminLogin.html");
        return; // Stop further processing
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
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
     nav {
            position: absolute; /* Positioning the nav */
            top: 10px; /* Distance from the top */
            right: 10px; /* Distance from the right */
            display: flex; /* Flexbox for layout */
            align-items: center; /* Center items vertically */
            z-index: 1000; /* Ensure nav is on top */
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
            padding: 10px; /* Padding around the nav */
            border-radius: 5px; /* Rounded corners */
        }

        nav a {
            color: white; /* Link text color */
            text-decoration: none; /* Remove underline */
            margin-left: 20px; /* Space between icons */
            font-size: 28px; /* Increased size of the icons */
            transition: color 0.3s; /* Smooth color transition on hover */
        }

        nav a:hover {
            color: #ffcc00; /* Change color on hover */
        }

        

        .container {
			background-color: rgba(255, 190, 255, 0.5);
            padding: 30px; /* Add padding */
            border-radius: 15px; /* Rounded corners */
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2); /* Shadow for depth */
            text-align: center; /* Center text */
            max-width: 400px; /* Set a maximum width */
            width: 100%; /* Full width */
        }

        h1 {
            margin-bottom: 20px; /* Space below the heading */
            font-size: 24px; /* Font size for the heading */
        }

        p {
            margin: 15px 0; /* Space around paragraphs */
            padding: 10px; /* Padding for paragraphs */
            border-radius: 10px; /* Rounded corners */
            background-color: rgba(0, 0, 0, 0.5); /* Background color */
            transition: transform 0.3s, text-shadow 0.3s; /* Smooth transition */
        }

        p:hover {
            text-shadow: 0 0 1px red; /* Text shadow on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        a {
            display: block; /* Make links block elements */
            color: white; /* Link text color */
            text-decoration: none; /* Remove underline */
            padding: 10px; /* Padding for links */
            border-radius: 5px; /* Rounded corners */
			background-color: rgba(255, 190, 255, 0.5);
        }

        a:hover {
            background-color: rgba(100, 100, 0, 0.2); /* Darker shade on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        .logout {
            margin-top: 20px; /* Space above logout link */
            font-size: 18px; /* Font size for logout */
        }
    </style>
</head>
<body>
<nav>
<a href="index.html" title="Profile"><i class="fas fa-user-circle"></i></a>
        <a href="logout" title=" Logout"><i class="fas fa-sign-out-alt"></i></a>

</nav>
    <div class="container">
        <h1>Hello <%= abean.getuName() %></h1> <!-- Assuming AdminBean has a getUsername() method -->
        <p><a href="AddProduct.html">Add Product</a></p>
        <p><a href="viewProducts">View Products</a></p>
        <div class="logout">
            <a href="index.html">Logout</a>
        </div>
    </div>
</body>
</html>