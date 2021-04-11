package hyber;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAO{
	
	public static UserDAO getUserDAOImpl() {
		return new UserDAO();
	}
	
	public UserDTO getUserDTO(int id) {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("UserDTO.getById");
		query.setInteger(0, id);
		List<UserDTO> result = query.list();
		session.getTransaction().commit();
		session.close();
		return result.get(0);
	}
	
	public UserDTO getUserByName(String uname,String password) {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("UserDTO.getByName");
		query.setString(0, uname);
		query.setString(1, password);
		List<UserDTO> result = query.list();
		session.getTransaction().commit();
		session.close();
		return result.get(0);
	}
	
	public void insertUser(UserDTO userDTO) {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		session.save(userDTO);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void updateUserFlag(String name,String password,int flag) {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("UserDTO.getByName");
		query.setString(0, name);
		query.setString(1, password);
		List<UserDTO> result = query.list();
		result.get(0).setFlag(flag);
		session.getTransaction().commit();
		session.close();
	}
	
	
}
