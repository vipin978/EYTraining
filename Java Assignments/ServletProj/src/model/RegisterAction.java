package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.RegisterService;

public class RegisterAction extends Action{
	
	public RegisterAction() {
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age =  Integer.parseInt(request.getParameter("age"));
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		RegisterService registerService = RegisterService.getRegisterService();
		
		registerService.insertUserInfo(name,age,password);
		session.setAttribute("name", name);
		session.setAttribute("password", password);
		
		return "register.success";
	}
}
