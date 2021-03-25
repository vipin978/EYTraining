package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model {
	
}


abstract class Action{
	
	static Connection con;
	static PreparedStatement statement;
	static PreparedStatement statement2;
	static PreparedStatement statement3;
	static PreparedStatement statement4;
	
	static{
			statement = null;statement2 = null;
	
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
				statement = con.prepareStatement("SELECT * FROM USER WHERE name = ? and pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				statement2 = con.prepareStatement("UPDATE user SET flag = 1 where name = ? and pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				statement3 = con.prepareStatement("UPDATE user SET flag = 0 where name = ? and pass = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				statement4 = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			}catch( Exception e){
				e.printStackTrace();
			} 
	}
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}


class LoginAction extends Action{
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = "";
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		HttpSession session=request.getSession();
		
		try {
			statement.setString(1, name);
			statement.setString(2, pass);
			ResultSet rs = statement.executeQuery();
			rs.last();
			if(rs.getRow() == 1) {
				rs.beforeFirst();
				while(rs.next()) {
					int flag = rs.getInt(4);
					if(flag == 1) {
						result = "Login.AlreadyLoggedIn";
					}
					else {
						System.out.println("camee yes");
						statement2.setString(1, name);
						statement2.setString(2, pass);
						statement2.executeUpdate();
						session.setAttribute("name", name);
						session.setAttribute("password", pass);
						result = "Login.welcome/"+name;
//						result = "Login.welcome/"+name+"/"+pass;
					}
				}
			}
			else {
				result = "Login.Register";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}


class LogOutAction extends Action{
	public LogOutAction() {
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;
//		String name = (String)request.getParameter("name");
//    	String password = (String)request.getParameter("password");
		HttpSession session=request.getSession();
		String name = (String)session.getAttribute("name");
		String password = (String)session.getAttribute("password");		
		System.out.println(name + "    "+password);
    	try {
    	statement3.setString(1, name);
    	statement3.setString(2, password);
    	statement3.executeUpdate();
    	}catch(Exception e) {
    		
    	}
    	result = "Register.login";
		return result;
	}
}


class RegisterAction extends Action{
	public RegisterAction() {
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = null;
		String name = (String)request.getParameter("name");
		String age = (String)request.getParameter("age");
		String password = (String)request.getParameter("password");
		int a = Integer.parseInt(age);
		HttpSession session=request.getSession();
	
		try {
			statement4.setString(1, name);
			statement4.setInt(2,a);
			statement4.setString(3, password);
			statement4.setInt(4, 1);
			statement4.executeUpdate();
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			result = "Login.welcome/"+name;
//			result = "Login.welcome/"+name+"/"+password;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}