package day19;

import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
//import java.sql.Date;
import java.time.LocalDateTime;
import day16Proj.Consignment1;
import day15Proj.*;

public class RMIServer extends UnicastRemoteObject implements BuisnessLogic{
	private static final long serialVersionUID = 1L;

	public RMIServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public CustomerData createInvoicePDF(int invNo) throws Exception {
		CustomerData data =  LoadDB.setValues().load(invNo);
		System.out.println(data.BillNo);
		return data;
	}
	
	@Override
	public CustomerData createInvoiceXLS(int invNo) throws Exception {
		CustomerData data =  LoadDB.setValues().load(invNo);
		return data;
	}
	
	@Override
	public LocalDateTime getDeliveryDate(int invNo) throws Exception {
//		InvoiceMasterDAOImpl invDAO = new InvoiceMasterDAOImpl();
//		InvoiceMasterDTO inDTO = invDAO.getInvoiceMaster(invNo);
		LocalDateTime ldt = Consignment1.getReachTime(LocalDateTime.now());
		return ldt;
	}
	
	@Override
	public void addItem(ItemsInfoDTO itDTO) throws RemoteException {
		ItemsInfoDAOImpl itDAO = new ItemsInfoDAOImpl();
		itDAO.insertItemsInfo(itDTO);
		System.out.println("DATA INSERTED");
	}
	
	@Override
	public void createInvoice(InvoiceMasterDTO invDTO, CustomerInfoDTO cusDTO, ItemsDTO itDTO) throws RemoteException {
		InvoiceMasterDAOImpl invDAO = new InvoiceMasterDAOImpl();
		invDAO.insertInvoiceMaster(invDTO);
		CustomerInfoDAOImpl cusDAO = new CustomerInfoDAOImpl();
		cusDAO.insertCustomerInfo(cusDTO);
		ItemsDAOImpl itemDAO =new ItemsDAOImpl();
		itemDAO.insertItems(itDTO);
		System.out.println("DATA INSERTED");
	}
	
	
	public static void main(String[] args) throws Exception{
		LocateRegistry.createRegistry(1099);
		RMIServer rmiService = new RMIServer();
		
		Naming.bind("rmi://localhost:1099/myservce", rmiService);
	}
}


//class RMIServerUtil{
//	public static LocalDateTime convertDT(Date date) {
//		int year = date.getYear();
//	}
//}
