package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from users;");
			while(rs.next()) {
				String s = rs.getString(2);
				System.out.println(s);
			}
			statement.close();
			con.close();
		}
		catch(Exception e) {
			
		}
	}
}
