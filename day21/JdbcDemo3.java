package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcDemo3 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from users;");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		for(int i =1;i<=rsmd.getColumnCount();i++) {
			System.out.println(rsmd.getColumnName(i));
			System.out.println(rsmd.getColumnLabel(i) + "  LABLE");
		}
	}
}
