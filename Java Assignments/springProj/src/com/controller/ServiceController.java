package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.ShopDTO;
import com.model.UserDTO;
import com.service.CustomerData;
import com.service.Email;
import com.service.InvoiceService;
import com.service.XlsCreation;



@Controller
@RequestMapping("service")
public class ServiceController {
	
	@Autowired
	public InvoiceService serv;
	
	
	public final InvoiceService getServ() {
		return serv;
	}

	public final void setServ(InvoiceService serv) {
		this.serv = serv;
	}

	@RequestMapping("do")
	public String getEmail(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		ArrayList<ShopDTO> a = (ArrayList<ShopDTO>) session.getAttribute("purchased");
		int total = 0;
		for(ShopDTO dto:a) {
			total += dto.getItemPrice();
		}
		session.setAttribute("total", total);
		this.insertEverthing(request); // inserting transaction
		FileAction file = new FileAction(request);
		file.generateExcel();
		if(action.equals("MailInvoice")) { 
			file.generatePDFandMail(request);
		}
	return "invoice";
	}
	
	public void insertEverthing(HttpServletRequest req) throws Exception{
		serv.insertInvoice(req);
		serv.insertItems(req);
	}
}

class FileAction{
	
	CustomerData data = new CustomerData();
	HttpSession session;
	
	public FileAction(HttpServletRequest request) {
		this.session = request.getSession();
		data.BillNo = 1;
		data.date = Date.valueOf(LocalDate.now());
		data.name = ((UserDTO)session.getAttribute("user")).getName();
		data.items = (ArrayList<ShopDTO>) session.getAttribute("purchased");
	}
	
	public void generatePDFandMail(HttpServletRequest request)throws ServletException, IOException {
		
		try {
			com.service.PDFService.createPdf(this.data);
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