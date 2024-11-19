<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pack1.ProductBean" %>
<%@ page import="pack1.ProductDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buy Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        h1 {
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .product-info {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Buy Product</h1>

    <%
        // Retrieve the product code from the request
        String pcode = request.getParameter("pcode");
        ProductDAO productDAO = new ProductDAO();
        ProductBean product = productDAO.getProductByCode(pcode); // Fetch product details

        // Check if the product exists
        if (product == null) {
    %>
        <div class="product-info">
            <p>Product not found. Please check the product code.</p>
        </div>
    <%
        } else {
    %>
        <div class="product-info">
            <p><strong>Product Name:</strong> <%= product.getPname() %></p>
            <p><strong>Price:</strong> $<%= product.getPprice() %></p>
            <p><strong>Available Quantity:</strong> <%= product.getPqty() %></p>
        </div>

        <form action="buy" method="post"> <!-- Action points to the servlet -->
            <input type="hidden" name="pcode" value="<%= pcode %>"> <!-- Hidden field for product code -->
            
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required min="1" max="<%= product.getPqty() %>"><br>
            
            <input type="submit" value="Buy Now">
        </form>
    <%
        }
    %>
</body>
</html>