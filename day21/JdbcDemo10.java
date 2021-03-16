package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class JdbcDemo10 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","password");
		Statement stament = con.createStatement();
		Savepoint sp = null;
		con.setAutoCommit(false);
		try {
			System.out.println("dkfsd");
			stament.execute("insert into users values (8,'dsf','sdfds',1)");
			stament.execute("insert into users values (9,'eter','nghs',1)");
			System.out.println("dkfsd");
			sp = con.setSavepoint("uptoinsert");
			stament.executeQuery("insert into users1 values '10','dsfsada','sdsadfds',1)");
			con.commit();
		}catch(Exception e) {
//			e.printStackTrace();
			con.rollback(sp);
			con.commit();
		}
	}
}
