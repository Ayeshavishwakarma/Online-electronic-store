<%@page import="pack1.CustomerBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer login</title>
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
            font-family: 'Arial', sans-serif; /* Set a default font */
            color: #fff; /* Default text color */
            text-align: center; /* Center text */
        }

        .container {
			background-color: rgba(255, 190, 255, 0.5);
            padding: 30px; /* Add some padding */
            border-radius: 15px; /* Rounded corners */
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.5); /* Shadow for depth */
            width: 100%; /* Set a width for the container */
            max-width: 400px; /* Set a maximum width */
        }

        h1 {
            margin-bottom: 20px; /* Space below the heading */
            font-size: 24px; /* Font size for the heading */
        }

        a {
            color: #ff1493; /* Change link color for better visibility */
            text-decoration: none; /* Remove underline from links */
            display: block; /* Make links behave like block elements */
            margin: 10px 0; /* Space between links */
            padding: 10px; /* Padding for links */
            border-radius: 5px; /* Rounded corners */
            background-color: rgba(255, 105, 180, 0.7); /* Pink background color */
            transition: background-color 0.3s, transform 0.3s; /* Smooth transition */
        }

        a:hover {
            background-color: rgba(255, 255, 255, 0.3); /* Light background on hover */
            transform: scale(1.05); /* Slightly enlarge on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer login</h1>
        <%
            CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
            if (cbean != null) {
                out.println("Welcome " + cbean.getuName() + "<br><br>");
            } else {
                response.sendRedirect("CustomerHome.jsp");
                return;
            }
        %>
        <a href="viewProducts">View Products</a>
        <a href="logout">Logout</a>
    </div>
</body>
</html>