<%@page import="pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Add Product</title>
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
			background-color: rgba(255, 190, 255, 0.5);
            padding: 30px; /* Add padding */
            padding-bottom:10px;
            border-radius: 15px; /* Rounded corners */
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.5); /* Shadow for depth */
            text-align: center; /* Center text */
            max-width: 400px; /* Set a maximum width */
            margin:50px;
            margin-top:5px;
            margin-bottom:5px;
            width: 100%; /* Full width */
        }

        h1 {
            margin-bottom: 20px; /* Space below the heading */
            font-size: 24px; /* Font size for the heading */
        }

        label {
            display: block; /* Make labels block elements */
            margin: 10px 0 5px; /* Space around labels */
            font-weight: bold; /* Bold labels */
        }

        input[type="text"],
        input[type="number"] {
            width: 100%; /* Full width */
            padding: 10px; /* Padding for input fields */
            margin-bottom: 15px; /* Space below input fields */
            border: 1px solid #ccc; /* Light border */
            border-radius: 5px; /* Rounded corners */
            background-color: rgba(255, 255, 255, 0.8); /* Light background for inputs */
            color: #333; /* Dark text color for inputs */
            transition: border-color 0.3s; /* Smooth transition */
        }

        input[type="text"]:focus,
        input[type="number"]:focus {
            border-color: #007BFF; /* Change border color on focus */
            outline: none; /* Remove default outline */
        }

        input[type="submit"] {
            background-color: #ff1493; /* Button background color */
            color: white; /* Button text color */
            border: none; /* Remove border */
            padding: 10px 15px; /* Padding for button */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition */
            margin-bottom: 15px; /* Space below the submit button */
        }

        input[type="submit"]:hover {
            background-color:  #ff1493; /* Green background for the button */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }

        .message {
            margin-bottom: 20px; /* Space below the message */
            color: yellow; /* Message color */
        }

        .view-product {
            display: inline-block; /* Make it an inline block */
            background-color:  #ff1493; /* Green background for the button */
            color: white; /* Button text color */
            padding: 10px 15px; /* Padding for button */
            border-radius: 5px; /* Rounded corners */
            text-decoration: none; /* Remove underline */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition */
        }

        .view-product:hover {
            background-color: rgba(255, 192, 203, 0.5); /* Light pink background on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Product</h1>
       
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.println("<div class='message'>" + msg + "</div>");
            }
        %>
        <form action="aps" method="post">
            <label for="pcode">Product Code:</label>
            <input type="text" id="pcode" name="pcode" required>
            
            <label for="pname">Product Name:</label>
            <input type="text" id="pname" name="pname" required>
            
            <label for="pcompany">Product Company:</label>
            <input type="text" id="pcompany" name="pcompany" required>
            
            <label for="pprice">Product Price:</label>
            <input type="number" id="pprice" name="pprice" step="0.01" required>
            
            <label for="pqty">Product Quantity:</label>
            <input type="number" id="pqty" name="pqty" min="0" required>
            
            <input type="submit" value="Add Product">        <a href="viewProducts" class="view-product">View Product</a>
            
        </form>
    </div>
</body>
</html>