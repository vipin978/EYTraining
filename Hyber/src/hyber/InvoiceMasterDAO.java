package hyber;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class InvoiceMasterDAO {
	
	public InvoiceMasterDAO() {
	}
	
	public static InvoiceMasterDAO getInvoiceMasterDAO() {
		return new InvoiceMasterDAO();
	}

	public List<InvoiceMasterDTO> getAllInvoices(){
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("getAll");
		List<InvoiceMasterDTO> result = query.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	public List<InvoiceMasterDTO> getInvoiceByUserId(int id){
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("getByUserId");
		query.setInteger(0, id);
		List<InvoiceMasterDTO> result = query.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	public void insertInvoice(int userId) {
		InvoiceMasterDTO invdto = new InvoiceMasterDTO();
		invdto.setDate(LocalDate.now());
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		UserDTO userdto =  (UserDTO)session.get(UserDTO.class,userId);
		invdto.setUser(userdto);
		session.save(userdto);
		session.save(invdto);
		session.getTransaction().commit();
		session.close();
	}
}
