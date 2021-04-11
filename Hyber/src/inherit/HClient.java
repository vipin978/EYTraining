package inherit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HClient {
	public static void main(String[] args) {
		
		Vehicle veh = new Vehicle();
		veh.setVehicleName("VEH");
		
		TwoWheeler tw = new TwoWheeler();
		tw.setVehicleName("Hero");
		tw.setSteeringHandle("Bike Steering");
		
		FourWheeler fw = new FourWheeler();
		fw.setVehicleName("Porse");
		fw.setSteeringWheel("Car Steering");
		
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(veh);
		session.save(tw);
		session.save(fw);	
		session.beginTransaction().commit();
	}
}
