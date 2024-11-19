<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Purchase Confirmation</title>
</head>
<body>
    <h1>Purchase Confirmation</h1>
    <p>Thank you for your purchase!</p>
    <p>Product Name: <%= request.getAttribute("productName") %></p>
    <p>Quantity: <%= request.getAttribute("quantity") %></p>
    <p>Unit Price: <%= request.getAttribute("unitPrice") %></p>
    <p>Total Price: <%= request.getAttribute("totalPrice") %></p>
    <a href="viewl">Back to Product List</a>
</body>
</html>