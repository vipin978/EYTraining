<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:2020/springweb4ey/spring/service/do" method = "post">
		<input type = "text" name = "mail"> <br> <br>
		<input type="submit" name="action" value="MailInvoice">
		<input type="submit" name="action" value="ViewInvoice"> 
	</form>
</body>
</html>