package day19;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

import day15Proj.*;

public interface BuisnessLogic extends Remote{
	public CustomerData createInvoicePDF(int invNo) throws Exception;
	public CustomerData createInvoiceXLS(int invNo) throws Exception;
	public LocalDateTime getDeliveryDate(int invNo) throws Exception;
	public void addItem(ItemsInfoDTO itDTO) throws RemoteException;
	public void createInvoice(InvoiceMasterDTO invDTO,CustomerInfoDTO cusDTO,ItemsDTO itDTO) throws RemoteException;
}
