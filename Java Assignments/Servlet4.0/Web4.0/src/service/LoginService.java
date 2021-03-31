package service;

import model.UserDAOImpl;
import model.UserDTO;

public class LoginService {
	
	private static LoginService singleInstance = null; 
	public static LoginService getLoginService() {
		if(singleInstance == null) {
			singleInstance = new LoginService();
		}
		return singleInstance;
	}
	
	public boolean checkUser(String name,String password) {
		UserDAOImpl userDAO = UserDAOImpl.getUserDAOImpl();
		UserDTO userDTO = userDAO.getUserByName(name, password);
		if(userDTO == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean checkIsOnline(String name,String password) {
		System.out.println("checkisonline");
		UserDAOImpl userDAO = UserDAOImpl.getUserDAOImpl();
		UserDTO userDTO = userDAO.getUserByName(name, password);
		if(userDTO.getFlag() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updateFlag(String name,String password,int flag) {
		UserDAOImpl userDAO = UserDAOImpl.getUserDAOImpl();
		userDAO.updateUserFlag(name, password, flag);
	}
}	
