package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example4
 */
public class Example4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    PreparedStatement statement;
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

    
    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        try
         {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
           statement = con.prepareStatement("Insert into user values(?,?,'sdfsdf',0)");
         }catch( Exception e){
        	 e.printStackTrace();
         }     
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("Called");
		int x = Integer.parseInt(age);
        try {
           statement.setString(1,name);
           statement.setInt(2,x);
           System.out.println(statement.executeUpdate());
          }catch(Exception e) { 
        	  e.printStackTrace();
          }
	}

}
