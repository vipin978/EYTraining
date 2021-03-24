package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterHandler
 */
public class RegisterHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
    PreparedStatement statement;
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("asfdfksdjk");
	}

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        try
         {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
           statement = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         }catch( Exception e){
        	 e.printStackTrace();
         }     
   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Called register");
		String name = (String)request.getParameter("name");
		String age = (String)request.getParameter("age");
		String password = (String)request.getParameter("password");
		int a = Integer.parseInt(age);
		try {
			statement.setString(1, name);
			statement.setInt(2,a);
			statement.setString(3, password);
			statement.setInt(4, 1);
			statement.executeUpdate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome1.jsp");
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			dispatcher.forward( request, response );
//			response.sendRedirect("welcome1.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
