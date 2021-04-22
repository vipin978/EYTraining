<%@page import="com.model.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<CENTER>
    <h1>Hey Welcome !! <%= ((UserDTO)session.getAttribute("user")).getName() %></h1>
    <br>    
    <a class="button" href="http://localhost:2020/springweb4ey/spring/shop/shop1">Shop</a>
    <br>
    <a class="button" href="http://localhost:2020/springweb4ey/spring/login/logout">LogOut</a>
    </CENTER>
</body>
</html>