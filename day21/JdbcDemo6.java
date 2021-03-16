package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo6 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement statement = con.createStatement();
		statement.execute("update users set ename = 'me0' where ename = 'vipin' ");
	}
}
