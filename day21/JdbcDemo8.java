package day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo8 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement statement = con.createStatement();
//		CallableStatement callStatement = con.prepareCall("{call procupdation()}");
//		callStatement.execute();
		ResultSet rs = statement.executeQuery("select * from users");
		while(rs.next()) {
			String uid = rs.getString(1);
			String name = rs.getString(2);
			String password = rs.getString(1);
			String flag = rs.getString(1);
			System.out.println("Uid : "+uid+" name: "+name+" password: "+password);
		}
	}
}
