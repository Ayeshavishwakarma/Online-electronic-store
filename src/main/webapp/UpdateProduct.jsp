<%@ page import="pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean abean = (AdminBean)session.getAttribute("abean");
String msg=(String)request.getAttribute("msg");
out.println("Hello Mr."+abean.getFname()+"<br><br>");
out.println(msg+"<br><br>");

%>
<a href="AddProduct.html">Add Product</a><br><br>
<a href="viewl">View Product</a><br><br>
<a href="logout">Logout</a><br><br>
</body>
</html>