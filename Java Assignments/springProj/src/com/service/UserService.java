package com.service;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.model.*;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public final UserDAO getUserDao() {
		return userDAO;
	}
	
	public final void setUserDao(UserDAO userDao) {
		this.userDAO = userDao;
	}
	
	
	public boolean checkUser(String name,String password) {
		UserDTO userDTO = userDAO.getUserByName(name, password);
		if(userDTO == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void insertNew(UserDTO user) {
		userDAO.insertUser(user);
		
	}
	
	public boolean checkIsOnline(String name,String password) {
		System.out.println("checkisonline");
		UserDTO userDTO = userDAO.getUserByName(name, password);
		if(userDTO.getFlag() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public UserDTO updateFlag(String name,String password,int flag) {
		return userDAO.updateUserFlag(name, password, flag);
	}
}
