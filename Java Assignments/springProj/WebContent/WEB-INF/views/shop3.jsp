<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to shop3 !!</h1><br>
	<spring:form commandName="list" method="post" action="getemail">
		<c:forEach items="${items}" var="items">
   			<spring:checkbox path="itemlist" value="${items.itemName}" label="${items.itemName}" /> 
		</c:forEach>
		<br><input type="submit" value="Buynow">
	</spring:form>
</body>
</html>