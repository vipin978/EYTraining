<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.button {
    display: block;
    width: 115px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}
</style>
</head>
<body>
	<CENTER>
    <h1>Hey Welcome !! <%=request.getAttribute("name")%></h1>
    <br>
    <a class="button" href="http://localhost:2020/eywebProj/LogOutHandler?name=<%=request.getAttribute("name")%>&password=<%=request.getAttribute("password")%>">LogOut</a>
    </CENTER>
</body>
</html>