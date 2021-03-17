package day19;

import java.rmi.Naming;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import day15Proj.CustomerData;
import day15Proj.PdfCreationWorkings;
import day15Proj.XlsCreationWorking;

public class RMIClient {
	Scanner scan=new Scanner(System.in);
	BuisnessLogic b;
	public static void main(String[] args) throws Exception{
		RMIClient client = new RMIClient();
		client.b = (BuisnessLogic)Naming.lookup("rmi://localhost:1099/myservce");
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Please select your choice...");
			System.out.println("1-Invoice to pdf");
			System.out.println("2-Invoice to xls");
			System.out.println("3-Get Delivery Date");
			System.out.println("4-Add an item");
			System.out.println("5-Invoice creation");
			int option = scan.nextInt();
			if(option == 1) {
				client.Pdf();
			}
			else if(option == 2) {
				client.xls();
			}
			else if(option == 3) {
				client.getDate();
			}
			else if(option == 4){
				client.addItem();
			}
			else {
				client.addInvoice();
			}
				
		}
	}
	
	public void Pdf() throws Exception{
		System.out.println("Enter invoice no.....");
		int invNo = scan.nextInt();
		CustomerData data =  b.createInvoicePDF(invNo);
		PdfCreationWorkings.createPdf(data);
	}
	
	public void xls() throws Exception{
		System.out.println("Enter invoice no.....");
		int invNo = scan.nextInt();
		CustomerData data =  b.createInvoiceXLS(invNo);
		XlsCreationWorking.createXLS(data);
	}
	
	public void getDate() throws Exception{
		System.out.println("Enter invoice no.....");
		System.out.println(b.getDeliveryDate(1));
	}
	
	public void addItem() throws Exception{
		ItemsInfoDTO itDTO  = new ItemsInfoDTO();
		
		System.out.println("Enter Item no....");
		itDTO.setItem_no(scan.nextInt());
		System.out.println("Enter Item description....");
		String descp = scan.next();
		itDTO.setItem_desp(descp);
		System.out.println("Enter Item price....");
		itDTO.setItem_price(scan.nextInt());
		System.out.println("Enter Item qty....");
		itDTO.setItem_qty(scan.nextInt());
		
		b.addItem(itDTO);
	}
	
	public void addInvoice() throws Exception{
		InvoiceMasterDTO invDTO = new InvoiceMasterDTO();
		CustomerInfoDTO cusDTO = new CustomerInfoDTO();
		ItemsDTO itDTO = new ItemsDTO();
		
		System.out.println("Enter InvNo no....");
		invDTO.setInv_no(scan.nextInt());
		System.out.println("Enter Customer no...");
		invDTO.setCustomer_no(scan.nextInt());
		Date date = Date.valueOf(LocalDate.now());
		invDTO.setInv_date(date);
		
		cusDTO.setCustomer_no(invDTO.getCustomer_no());
		System.out.println("Enter the customer city.....");
		String city = scan.next();
		cusDTO.setCustomer_address(city);
		System.out.println("Enter the customer mail id.....");
		String email = scan.next();
		cusDTO.setCustomer_email(email);
		System.out.println("Enter the phone no of customer ....");
		email = scan.next();
		cusDTO.setCustomer_phone(email);
		
		itDTO.setInv_no(invDTO.getInv_no());
		System.out.println("Enter the item no....");
		itDTO.setItem_no(scan.nextInt());
		System.out.println("Enter the units of item ...");
		itDTO.setItem_unt(scan.nextInt());
		
		b.createInvoice(invDTO, cusDTO, itDTO);
	}

}
