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
	<spring:form commandName="user" method="post" action="submitForm">
	
		UserName:<spring:input path="name"/>
		PassWord:<spring:input path="pass"/>
		
		<input type="submit" value="login">
		
	</spring:form>
</body>
</html>