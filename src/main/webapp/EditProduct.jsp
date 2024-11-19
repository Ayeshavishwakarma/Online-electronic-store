<%@ page import="pack1.ProductBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('image/cloth.jpg'); /* Path to your background image */
            background-size: cover; /* Cover the entire body */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent the image from repeating */
            color: white; /* Set text color to white for better contrast */
        }
        .container {
			background-color: rgba(255, 190, 255, 0.5);
            width: 50%; /* Set a fixed width for the form container */
            padding: 2%;
            margin: 5% auto; /* Center the container */
            border-radius: 15px; /* Rounded corners */
            text-align: center; /* Center text */
        }
        h2 {
            color: white; /* Set heading color */
            margin-bottom: 20px; /* Space below the heading */
        }
        label {
            color: white; /* Label color */
            margin-top: 10px; /* Space above labels */
        }
        input[type="text"],
        input[type="number"] {
            width: 100%; /* Full width for input fields */
            padding: 10px; /* Padding for input fields */
            margin: 10px 0; /* Space above and below input fields */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
        }
        input[type="submit"] {
            background-color: #ff1493; /* Button background color */
            color: white; /* Button text color */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
            padding: 10px 20px; /* Padding for button */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s; /* Smooth transition */
        }
        input[type="submit"]:hover {
            background-color: rgba(255, 192, 203, 0.5); /* Light pink background on hover */
        }
        button {
                    background-color: #ff1493; /* Button background color */
        
            background-color: #ff1493; /* Button background color */
            color: white; /* Button text color */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
            padding: 10px 20px; /* Padding for button */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s; /* Smooth transition */
        }
        button:hover
        {
                    background-color: rgba(255, 192, 203, 0.5); /* Light pink background on hover */
        
        }
       
        a
        {
        color: white; /* White text */
        }
    </style>
</head>
<body>
<center>
<%
    // Display the message if it exists
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
        <p><strong><%= message %></strong></p>
<%
    }

    ProductBean productToEdit = (ProductBean) request.getAttribute("productToEdit");
    if (productToEdit != null) {
%>
        <div class="container">
            <h2>Edit Product Details</h2>
            <form action="<%= request.getContextPath() %>/updateProduct" method="post">
                <input type="hidden" name="pcode" value="<%= productToEdit.getPcode() %>">
                <label for="pname">Name:</label>
                <input type="text" id="pname" name="pname" value="<%= productToEdit.getPname() %>" required>
                
                <label for="pcompany">Company:</label>
                <input type="text" id="pcompany" name="pcompany" value="<%= productToEdit.getPcompany() %>" required>
                
                <label for="pprice">Price:</label>
                <input type="number" id="pprice" name="pprice" value="<%= productToEdit.getPprice() %>" step="0.01" required>
                
                <label for="pqty">Quantity:</label>
                <input type="number" id="pqty" name="pqty" value="<%= productToEdit.getPqty() %>" required>
                
                <input type="submit" value="Update Product"> <button><a href="viewProducts">Product List</a></button>
                
            </form>
        </div>
<%
    } else {
%>
<p>Product not found.</p>
<%
    }
%>
</center>
</body>
</html>