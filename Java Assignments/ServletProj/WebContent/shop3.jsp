<%@page import="model.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/shop.css">
<title>Insert title here</title>
</head>
<body>
	<center><h1>TOY SHOP</h1></center>
      <form action = "http://localhost:2020/eyProj2/ActionServlet?id=shopAction&current=shop3" method = "post">
        <div class="container">
          <ul>
            <li>
              <input type="checkbox" id="myCheckbox1" name = "img1" value = "t1"/>
              <label for="myCheckbox1"><img src= <%= ((ArrayList<ShopDTO>)request.getAttribute("items")).get(0).getItemURL() %> /></label>
            </li>
            <li>
              <input type="checkbox" id="myCheckbox2" name = "img2" value="t2"/>
              <label for="myCheckbox2"><img src= <%= ((ArrayList<ShopDTO>)request.getAttribute("items")).get(1).getItemURL() %> /></label>
            </li>
            <li>
              <input type="checkbox" id="myCheckbox3" name = "img3" value = "t3"/>
              <label for="myCheckbox3"><img src=<%= ((ArrayList<ShopDTO>)request.getAttribute("items")).get(2).getItemURL() %> /></label>
            </li>
          </ul>
        </div>
        <center>
          <input type="submit" name="action" value="BuyNow">
          <input type="submit"  name="action" value="Logout">
        </center>
      </form>
</body>
</html>

