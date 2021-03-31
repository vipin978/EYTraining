package service;

import model.UserDAOImpl;

import model.UserDTO;

public class RegisterService {
	
	private static RegisterService singleInstance = null; 
	public static RegisterService getRegisterService() {
		if(singleInstance == null) {
			singleInstance = new RegisterService();
		}
		return singleInstance;
	}
	
	public void insertUserInfo(String name,int age,String password) {
		UserDAOImpl userDAO = UserDAOImpl.getUserDAOImpl();
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setAge(age);
		userDTO.setPass(password);
		userDTO.setFlag(0);
		userDAO.insertUser(userDTO);
	}
	
}
