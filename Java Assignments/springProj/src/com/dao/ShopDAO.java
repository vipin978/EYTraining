package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.ShopDTO;

@Repository
public class ShopDAO{
	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public ShopDTO getShopDTO(String name) {
		Session session = this.factory.getCurrentSession();
		Query query = session.getNamedQuery("ShopDTO.byItemName");
		query.setString(0, name);
		List<ShopDTO> result = query.list();
		return result.get(0);
	}
	
	
	public List<ShopDTO> getAllItem(int no) {
		Session session = this.factory.getCurrentSession();
		Query query = session.getNamedQuery("ShopDTO.everything");
		query.setInteger(0, no);
		List<ShopDTO> result = query.list();
		return result;
	}
	
	public void insertShop(ShopDTO shopDTO) {
		Session session = this.factory.getCurrentSession();
		session.save(shopDTO);
	}
	
}
