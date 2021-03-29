package model;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;

public class LoginAction extends Action{
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String result = null;
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		LoginService loginService=LoginService.getLoginService();
		
		if(loginService.checkUser(name,password)) {
			if(!loginService.checkIsOnline(name,password)) {
				session.setAttribute("name", name);
				session.setAttribute("password", password);
				loginService.updateFlag(name,password, 1);
				result = "shop1";
			}else {
				result = "login.already";
			}
		}else {
			result = "login.failure";
		}
		return result;
	}
}
