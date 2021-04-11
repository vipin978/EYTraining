package hyber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HybernateSession {
	static Configuration cfg;
	static SessionFactory factory;
	
	static {
		cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
}
