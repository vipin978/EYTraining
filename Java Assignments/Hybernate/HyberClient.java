package hyber;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

public class HyberClient {
	public static void main(String[] args) {
		UserDTO user = new UserDTO("user1", 14, "pass1", 0);
		UserDTO user2 = new UserDTO("user2", 15, "pass2", 0);
		UserDAO userDAO = UserDAO.getUserDAOImpl();
		InvoiceMasterDAO invDAO = InvoiceMasterDAO.getInvoiceMasterDAO();
		userDAO.insertUser(user);
		userDAO.insertUser(user2);
		invDAO.insertInvoice(1);
		invDAO.insertInvoice(1);
		List<InvoiceMasterDTO> result =  invDAO.getInvoiceByUserId(1);
		System.out.println(result.size());
	}
}
