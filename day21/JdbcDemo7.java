package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcDemo7 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement stament = con.createStatement();
		PreparedStatement ps = con.prepareStatement("update users set ename = 'vipin' where ename = ?");
		PreparedStatement ps2 = con.prepareStatement("insert into users values (?,?,?,?)");
		ps.setString(1, "me0");
		ps.setString(1, "me2");
		ps2.setInt(1, 6);
		ps2.setString(2, "heyy");
		ps2.setString(3, "dsfkn");
		ps2.setInt(4, 1);
		ps.execute();
		ps2.execute();
	}
}
