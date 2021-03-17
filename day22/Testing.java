package day19;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import day15Proj.*;

public class Testing {
	public static void main(String[] args) throws Exception{
		InvoiceMasterDTO invDTO;
		InvoiceMasterDAOImpl invDAO = new InvoiceMasterDAOImpl();
		CustomerInfoDTO ciDTO;
		CustomerInfoDAOImpl ciDAO = new CustomerInfoDAOImpl();
		List<ItemsInfoDTO> itinfoDTO;
		ItemsInfoDAOImpl itinfoDAO = new ItemsInfoDAOImpl();
		ItemsDTO itemsDTO;
		ItemsDAOImpl itemsDAO = new ItemsDAOImpl();
		
		Date date = Date.valueOf(LocalDate.now());
		System.out.println(date);
//		PdfCreationWorkings.createPdf(1);
//		Date s = new Date(2021,4,4);
//		System.out.println(s);
//		invDTO = new InvoiceMasterDTO();
//		invDTO.setCustomer_no(2);
//		invDTO.setInv_no(2);
//		invDTO.setInv_date(s);
//		invDAO.insertInvoiceMaster(invDTO);
//		
//		
		
	}
}
