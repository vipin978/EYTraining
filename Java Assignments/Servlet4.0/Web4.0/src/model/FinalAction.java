package model;

import java.io.IOException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerData;
import service.Email;
import service.PDFService;
import service.XlsCreation;

public class FinalAction extends Action{
	public FinalAction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		ArrayList<ShopDTO> a = (ArrayList<ShopDTO>) session.getAttribute("items");
		int total = 0;
		for(ShopDTO dto:a) {
			total += dto.getItemPrice();
		}
		session.setAttribute("total", total);
		FileAction file = new FileAction(request);
		file.generateExcel();
		if(action.equals("MailInvoice")) { 
			file.generatePDFandMail(request, response);
		}
	return "invoice";
		
	}
}



class FileAction{
	
	CustomerData data = new CustomerData();
	HttpSession session;
	
	public FileAction(HttpServletRequest request) {
		this.session = request.getSession();
		data.BillNo = 1;
		data.date = Date.valueOf(LocalDate.now());
		data.name = (String)session.getAttribute("name");
		data.items = (ArrayList<ShopDTO>) session.getAttribute("items");
	}
	
	public void generatePDFandMail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		try {
			PDFService.createPdf(this.data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			Email.send(request.getParameter("mail"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void generateExcel() {
		try {
		XlsCreation.createXLS(data);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

