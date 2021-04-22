package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvoiceMasterDAO;
import com.dao.TransactionDAO;
import com.dao.UserDAO;
import com.model.InvoiceMasterDTO;
import com.model.TransactionDTO;
import com.model.UserDTO;

@Service
@Transactional
public class InvoiceService {
	
	@Autowired
	private InvoiceMasterDAO invoice;
	
	public final InvoiceMasterDAO getInvoice() {
		return invoice;
	}
	
	public final void setInvoice(InvoiceMasterDAO invoice) {
		this.invoice = invoice;
	}
	
	@Autowired
	private TransactionDAO trans;

	public final TransactionDAO getTrans() {
		return trans;
	}

	public final void setTrans(TransactionDAO trans) {
		this.trans = trans;
	}
	
	public void insertInvoice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		System.out.println(user.getUid());
		InvoiceMasterDTO invoices = invoice.insertInvoice(user.getUid());
		session.setAttribute("invoice", invoices);
	}
	
	public void insertItems(HttpServletRequest request) {
		trans.insertTrans(request);
	}
}
