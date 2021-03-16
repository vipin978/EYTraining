package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo5 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement stament = con.createStatement();
		stament.execute("insert into users values (4,'me4','smt4',1)");
	}
	
}
