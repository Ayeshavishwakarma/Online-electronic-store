<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pack1.Order" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bill</title>
    <style>
        body {
            background-image: url('image/cloth.jpg'); /* Background image */
            background-size: cover; /* Cover the entire viewport */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repetition */
            margin: 0; /* Remove default margin */
            padding: 20px; /* Add padding */
            font-family: Arial, sans-serif; /* Font style */
            color: #333; /* Text color */
        }

        .container {
            max-width: 600px; /* Max width for the container */
            margin: auto; /* Center the container */
            background: rgba(255, 255, 255, 0.9); /* White background with slight transparency */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
            padding: 20px; /* Padding inside the container */
        }

        h1 {
            text-align: center; /* Center the heading */
            color: #4CAF50; /* Green color for the heading */
        }

        table {
            width: 100%; /* Full width */
            border-collapse: collapse; /* Collapse borders */
            margin-top: 20px; /* Space above the table */
        }

        th, td {
            border: 1px solid #ddd; /* Light gray border */
            padding: 10px; /* Padding inside cells */
            text-align: center; /* Center text */
        }

        th {
            background-color: #4CAF50; /* Green background for header */
            color: white; /* White text for header */
        }

        .thank-you {
            text-align: center; /* Center the thank you message */
            font-size: 18px; /* Font size for the message */
            color: #4CAF50; /* Green color for the message */
            margin-top: 20px; /* Space above the message */
        }

        .button {
            display: block; /* Make button a block element */
            width: 100%; /* Full width */
            padding: 10px; /* Padding inside button */
            margin-top: 20px; /* Space above button */
            background-color: #4CAF50; /* Green background */
            color: white; /* White text */
            border: none; /* No border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size for button */
            text-align: center; /* Center text in button */
            text-decoration: none; /* Remove underline */
            transition: background-color 0.3s; /* Smooth transition */
        }

        .button:hover {
            background-color: #45a049; /* Darker green on hover */
        }

        /* Additional styles for better spacing */
        p {
            text-align: center; /* Center text */
            font-size: 16px; /* Font size for paragraphs */
            color: #333; /* Text color */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Order Summary</h1>

        <%
            // Retrieve the order object from the session
            Order order = (Order) session.getAttribute("order");
            
            // Check if the order object is not null
            if (order != null) {
        %>
            <table>
                <tr>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
                <tr>
                    <td><%= order.getProductCode() %></td>
                    <td><%= order.getProductName() %></td>
                    <td><%= order.getQuantity() %></td>
                    <td><%= String.format("%.2f", order.getPrice()) %></td>
                    <td><%= String.format("%.2f", order.getTotalPrice()) %></td>
                </tr>
            </table>

            <div class="thank-you">
                <p>Thank you for shopping with us!</p>
                <p>We appreciate your business!</p>
            </div>

 <%
            } else {
        %>
            <p>No order found.</p>
        <%
            }
        %>

        <a href="viewProducts" class="button">Back to Products</a>
    </div>
</body>
</html>