package day21;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JdbcDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		
		DatabaseMetaData metaData = con.getMetaData();
		System.out.println(metaData.getURL());
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(con);
	}
}

