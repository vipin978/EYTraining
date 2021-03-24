package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOutHandler
 */
public class LogOutHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
    PreparedStatement statement;
    

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        try
         {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
           statement = con.prepareStatement("UPDATE user SET flag = 0 where name = ? and pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         }catch( Exception e){
        	 e.printStackTrace();
         }     
   }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name = (String)request.getParameter("name");
    	String password = (String)request.getParameter("password");
    	System.out.println(name+" "+request.getRequestURL());
    	try {
    	statement.setString(1, name);
    	statement.setString(2, password);
    	statement.executeUpdate();
    	}catch(Exception e) {
    		
    	}
    	response.sendRedirect("login.html");
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
