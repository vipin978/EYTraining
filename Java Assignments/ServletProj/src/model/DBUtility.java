package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	
	static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void closeConnection() {
		try{
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
