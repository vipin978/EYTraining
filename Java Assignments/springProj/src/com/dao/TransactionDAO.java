package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.*;

@Repository
public class TransactionDAO {
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public void insertTrans(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<ShopDTO> shopdtos = (ArrayList<ShopDTO>) session.getAttribute("purchased");
		InvoiceMasterDTO invdto = (InvoiceMasterDTO)session.getAttribute("invoice");
		Session sessionhy = factory.getCurrentSession();
		int invno = invdto.getInv_no();
		
		for(ShopDTO s:shopdtos) {
			TransactionDTO trans = new TransactionDTO();
			trans.setInvoice_id(invno);
			trans.setItem_no(s.getItemNo());
			sessionhy.save(trans);
		}
		
	}
	
	public List<TransactionDTO> getTransactionByInvoiceNo(int invId){
		Session session = factory.getCurrentSession();
		Query query = session.getNamedQuery("getByUserId");
		query.setInteger(0, invId);
		List<TransactionDTO> result = query.list();
		return result;
	}
}
