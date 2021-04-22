package com.dao;


import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.*;

@Repository
public class UserDAO{
	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public UserDTO getUserDTO(int id) {
		Session session = factory.getCurrentSession();
		Query query = session.getNamedQuery("UserDTO.getById");
		query.setInteger(0, id);
		List<UserDTO> result = query.list();
		return result.get(0);
	}
	
	public UserDTO getUserByName(String uname,String password) {
		System.out.println(factory.isClosed());
		Session session = factory.getCurrentSession();
		Query query = session.getNamedQuery("UserDTO.getByName");
		query.setString(0, uname);
		query.setString(1, password);
		List<UserDTO> result = query.list();
		if(result.size() > 0) {
		return result.get(0);
		}
		else {
			return null;
		}
	}
	
	public void insertUser(UserDTO userDTO) {
		Session session = this.factory.getCurrentSession();
		session.save(userDTO);
	}
	
	
	public UserDTO updateUserFlag(String name,String password,int flag) {
		Session session = this.factory.getCurrentSession();
		Query query = session.getNamedQuery("UserDTO.getByName");
		query.setString(0, name);
		query.setString(1, password);
		List<UserDTO> result = query.list();
		result.get(0).setFlag(flag);
		return result.get(0);
	}
	
	
}
