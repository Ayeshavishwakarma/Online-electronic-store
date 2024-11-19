<%@ page import="pack1.ProductBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Product Details</title>
    <style>
        body {
            background-color: #f4f4f4; /* Light background color */
            font-family: Arial, sans-serif; /* Font style */
            color: #333; /* Text color */
            margin: 0; /* Remove default margin */
            padding: 20px; /* Add padding */
        }

        .container {
            max-width: 600px; /* Max width for the container */
            margin: auto; /* Center the container */
            background: white; /* White background for the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
            padding: 20px; /* Padding inside the container */
        }

        h2 {
            text-align: center; /* Center the heading */
            color: #4CAF50; /* Green color for the heading */
        }

        .product-details {
            margin-bottom: 20px; /* Space below product details */
        }

        .thank-you {
            text-align: center; /* Center the thank you message */
            font-size: 18px; /* Font size for the message */
            color: #4CAF50; /* Green color for the message */
            margin-top: 20px; /* Space above the message */
        }

        .button {
            display: block; /* Make buttons block elements */
            width: 100%; /* Full width */
            padding: 10px; /* Padding inside buttons */
            margin-top: 10px; /* Space above buttons */
            background-color: #4CAF50; /* Green background */
            color: white; /* White text */
            border: none; /* No border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size for buttons */
            transition: background-color 0.3s; /* Smooth transition */
        }

        .button:hover {
            background-color: #45a049; /* Darker green on hover */
        }

        hr {
            border: 1px solid #4CAF50; /* Green line for the separator */
        }
    </style>
</head>
<body>
    <div class="container">
        <center>
        <%
            ProductBean product = (ProductBean) request.getAttribute("products");
            if (product != null) {
        %>
            <h2>Product Details</h2>
            <div class="product-details">
                <p><strong>Code:</strong> <%= product.getPcode() %></p>
                <p><strong>Name:</strong> <%= product.getPname() %></p>
                <p><strong>Company:</strong> <%= product.getPcompany() %></p>
                <p><strong>Price:</strong> <%= String.format("%.2f", product.getPprice()) %></p>
                <p><strong>Available Quantity:</strong> <%= product.getPqty() %></p>
            </div>

            <!-- Form to Buy the Product -->
            <form action="buy" method="post">
                <label for="quantity">Enter Quantity:</label>
                <input type="number" id="quantity" name="quantity" min="1" max="<%= product.getPqty() %>" required>
                <input type="hidden" name="pcode" value="<%= product.getPcode() %>">
                <input type="submit" class="button" value="Buy">
            </form>

            <hr>

            <!-- Form to Update Product Details -->
            <h3>Update Product Details</h3>
            <form action="update" method="post">
                <input type="hidden" name="pcode" value="<%= product.getPcode() %>">
                <label for="pprice">Price:</label>
                <input type="number" id="pprice" name="pprice" value="<%= product.getPprice() %>" step="0.01" required>
                <br>
                <label for="pqty">Quantity:</ <input type="number" id="pqty" name="pqty" value="<%= product.getPqty() %>" required>
                <br>
                <input type="submit" class="button" value="Update Product">
            </form>

            <div class="thank-you">
                <p>Thank you for shopping with us!</p>
                <p>We appreciate your business!</p>
            </div>

        <%
            } else {
        %>
            <p>Product not found.</p>
        <%
            }
        %>
        <a href="ViewProduct.jsp" class="button">Back to Product List</a>
        </center>
    </div>
</body>
</html>