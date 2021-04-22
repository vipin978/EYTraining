package com.dao;


import java.time.LocalDate;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.InvoiceMasterDTO;
import com.model.UserDTO;

@Repository
public class InvoiceMasterDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	

	public List<InvoiceMasterDTO> getAllInvoices(){
		Session session = this.factory.getCurrentSession();
		Query query = session.getNamedQuery("getAll");
		List<InvoiceMasterDTO> result = query.list();
		return result;
	}
	
	public List<InvoiceMasterDTO> getInvoiceByUserId(int id){
		Session session = this.factory.getCurrentSession();
		Query query = session.getNamedQuery("getByUserId");
		query.setInteger(0, id);
		List<InvoiceMasterDTO> result = query.list();
		return result;
	}
	
	public InvoiceMasterDTO insertInvoice(int userId) {
		InvoiceMasterDTO invdto = new InvoiceMasterDTO();
		invdto.setDate(LocalDate.now());
		Session session = this.factory.getCurrentSession();
		UserDTO userdto =  (UserDTO)session.get(UserDTO.class,userId);
		invdto.setUser(userdto);
		session.save(userdto);
		session.save(invdto);
		return invdto;
	}
}
