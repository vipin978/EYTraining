package day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo9 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement stament = con.createStatement();
//		CallableStatement cs = con.prepareCall("{call procUpdation()}");
//		cs.execute();
		ResultSet rs = stament.executeQuery("select * from users");
		
		while(rs.next()) {
			String name = rs.getString(2);
			System.out.println(name);
		}
	}
}
