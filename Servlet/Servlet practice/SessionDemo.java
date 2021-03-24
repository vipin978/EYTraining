package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletOutputStream out = response.getOutputStream();
		Object obj = session.getAttribute("count");
		if(obj == null) {
			session.setAttribute("count", 1);
			out.println("<h1> first time </h1>");
		}
		else {
			out.println("<h1> Not first time ur count is </h1>"+obj.toString());
			int x = Integer.parseInt(obj.toString());
			session.setAttribute("count", ++x);
		}
	}
}
