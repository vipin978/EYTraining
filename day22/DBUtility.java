package day19;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtility {
	
	private static Properties props;
	static {
		try {
			props = new Properties();
			props.load(new FileInputStream("src/dbConfig.properties"));
			Class.forName(props.getProperty("driver"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static ThreadLocal<Connection> tlocal = new ThreadLocal<>();
	
	public static Connection getConnection() {
		Connection con = tlocal.get();
		if(con == null) {
			try {
				con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
//				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeConnection(Exception exp) {
		Connection con = tlocal.get();
		try {
			if(exp == null){
//				con.commit();
//				System.out.println(con);
			}
//			con.close();
//			tlocal.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
