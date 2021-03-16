package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo4 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement statement = con.createStatement();
		System.out.println(statement.executeUpdate("insert into users values (3,'me3','smt3',1)"));
		statement.close();
		con.close();
	}
}
