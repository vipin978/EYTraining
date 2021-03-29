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

public class FinalAction extends Action{
	public FinalAction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("MailPDF")) { 
			PDFAction.generate(request, response);
			return "payment";
		}else {
			return "invoice";
		}
		
	}
}



class PDFAction{
	public static void generate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerData data = new CustomerData();
		
		data.BillNo = 1;
		data.date = Date.valueOf(LocalDate.now());
		data.name = (String)session.getAttribute("name");
		data.items = (ArrayList<ShopDTO>) session.getAttribute("items");
		
		try {
			PDFService.createPdf(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			Email.send(request.getParameter("mail"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
