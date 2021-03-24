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
 * Servlet implementation class LoginHandler
 */
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 	Connection con;
	    PreparedStatement statement;
	    PreparedStatement statement2;
	    
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
	    		con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
	           statement = con.prepareStatement("SELECT * FROM USER WHERE name = ? and pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	           statement2 = con.prepareStatement("UPDATE user SET flag = 1 where name = ? and pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	         }catch( Exception e){
	        	 e.printStackTrace();
	         }     
	   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		
		try {
			statement.setString(1, name);
			statement.setString(2, pass);
			ResultSet rs = statement.executeQuery();
			rs.last();
			if(rs.getRow() == 1) {
				rs.beforeFirst();
				while(rs.next()) {
					int flag = rs.getInt(4);
					System.out.println("Flag ...."+flag);
					if(flag == 1) {
						response.sendRedirect("AlreadyLogin.html");
					}
					else {
						statement2.setString(1, name);
						statement2.setString(2, pass);
						statement2.executeUpdate();
						RequestDispatcher dispatcher = request.getRequestDispatcher("welcome1.jsp");
						request.setAttribute("name", name);
						request.setAttribute("password", pass);
						dispatcher.forward( request, response );
//						response.sendRedirect("welcome.html");
					}
				}
			}
			else {
				response.sendRedirect("register.html");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
