<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pack1.ProductBean" %>
<%@ page import="pack1.AdminBean" %>
<%@ page import="pack1.CustomerBean" %>

<html>
<head>
    <title>View Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <style>
        body {
            background-image: url('image/cloth.jpg'); /* Path to your background image */
            background-size: cover; /* Cover the entire body */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent the image from repeating */
            color: white; /* Set text color to white for better contrast */
        }
        h1 {
            color: white; /* Set heading color */
            margin-top: 20px; /* Space above the heading */
        }
        .container {
			background-color: rgba(255, 190, 255, 0.5);
            width: 80%;
            padding: 2%;
            margin: 5% auto; /* Adjusted margin for better spacing */
            text-align: center;
            border-radius: 15px;
        }
        .swiper {
            width: 100%;
            height: 400px; /* Set a fixed height for the swiper */
        }
        .swiper-slide {
            display: grid;
            justify-content: center;
            align-items: center;
            margin-right: 10px; /* Space between cards */
        }
        .card {
            background-color: rgba(255, 255, 255, 0.9); /* Light background for cards */
            border: none; /* Remove border */
            border-radius: 10px; /* Rounded corners */
            transition: transform 0.3s; /* Smooth transform on hover */
            width: 300px; /* Increased width for better visibility */
    height: 400px; /* Height can remain the same or be adjusted as needed */
    margin: 10px; /* Space between cards */
    padding: 15px; 
        }
        .card:hover {
            transform: scale(1.05); /* Slightly enlarge on hover */
        }
        .card-title {
            font-size: 1.2rem; /* Adjust title font size */
            color: #333; /* Dark text color for title */
        }
        .card-text {
            color: #555; /* Darker text color for product details */
        }
        .card-footer {
            background-color: transparent; /* Transparent footer */
            border-top: none; /* Remove border */
        }
        .btn {
            background-color: #ff69b4; /* Button background color */
            color: white; /* Button text color */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s; /* Smooth transition */
        }
        .btn:hover {
            background-color: #0056b3; /* Darker shade on hover */
        }
    </style>
</head>
<body>
<center><h1>Product List</h1></center>

<% 
    // Check for the message attribute and display it
    String message = (String) request.getAttribute("msg");
    if (message != null && !message.isEmpty()) {
%>
    <p><strong><%= message %></strong></p>
<%
    }
%>

<% 
    // Retrieve the list of products
    ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products");
    System.out.println("Products in JSP: " + products); // Log products

    if (products != null && !products.isEmpty()) {
%>
<div class="container">
    <div class="swiper">
        <div class="swiper-wrapper">
            <% 
                // Check if the user is an admin or a customer
                AdminBean abean = (AdminBean) session.getAttribute("abean");
                CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");

                for (ProductBean product : products) { 
            %>
            <div class="swiper-slide">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title"><%= product.getPcode() %></h5>
                        <p class="card-text"><%= product.getPname() %></p>
                        <p class="card-text">Quantity: <%= product.getPqty() %></p>
                        <p class="card-text">Price: <%= product.getPprice() %></p>
                    </div>
                     <div class="card-footer">
                        <% if (abean != null) { %> <!-- If admin is logged in -->
                            <form action="editProduct" method="GET" style="display:inline;">
                                <input type="hidden" name="pcode" value="<%= product.getPcode() %>"/>
                                <input type="submit" class="btn" value="Edit"/>
                            </form>
                            <form action="delete" method="POST" style="display:inline;">
                                <input type="hidden" name="pcode" value="<%= product.getPcode() %>"/>
                                <input type="submit" class="btn" value="Delete"/>
                            </form>
                        <% } else if (cbean != null) { %> <!-- If customer is logged in -->
                            <form action="buyProduct" method="POST" style="display:inline;">
                                <input type="hidden" name="pcode" value="<%= product.getPcode() %>"/>
                                <label for="quantity">Quantity:</label>
                                <input type="number" name="quantity" min="1" max="100" required/>
                                <input type="submit" class="btn" value="Buy"/>
                            </form>
                        <% } else { %>
                            <p>Please log in to see actions.</p>
                        <% } %>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
        <!-- Add navigation buttons -->
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
        <!-- Add pagination -->
        <div class="swiper-pagination"></div>
    </div>
</div>
<% 
    } else { 
%>
    <p>No products available.</p>
<% 
    } 
%>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    var swiper = new Swiper('.swiper', {
        slidesPerView: 3, // Number of slides to show at once
        spaceBetween: 2, // Space between slides
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        breakpoints: {
            // Responsive breakpoints
            640: {
                slidesPerView: 1, // 1 slide on small screens
            },
            768: {
                slidesPerView: 2, // 2 slides on medium screens
            },
            1024: {
                slidesPerView: 3, // 3 slides on large screens
            },
        },
    });
</script>
</body>
</html>