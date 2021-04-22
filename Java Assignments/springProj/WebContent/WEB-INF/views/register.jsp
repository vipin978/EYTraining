<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>You are new here </h1>
	<spring:form commandName="user" method="post" action="register">
	
		UserName:<spring:input path="name"/>
		PassWord:<spring:input path="pass"/>
		Age:<spring:input path="age"/>
		
		<input type="submit" value="login">
		
	</spring:form>
</body>
</html>