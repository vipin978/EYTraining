<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ResourceBundle rb = (ResourceBundle)session.getAttribute("rb"); %>
<form class="" action="http://localhost:2020/eyWeb4.0/ActionServlet?id=login" method="post">
      <CENTER>
        <B> <%= rb.getString("username") %>: </B>
         <INPUT TYPE=TEXT NAME="name"> <P>
        <B> <%= rb.getString("password")%>: </B>
        <INPUT TYPE=TEXT NAME="password"> <p>
         <INPUT TYPE=SUBMIT>
       </CENTER>
    </form>

</body>
</html>