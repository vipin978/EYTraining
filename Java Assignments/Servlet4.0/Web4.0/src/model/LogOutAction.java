package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;

public class LogOutAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String result = null;
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		String password = (String)session.getAttribute("password");
		System.out.println(name + "   "+ password);
		LoginService service = LoginService.getLoginService(); 
		service.updateFlag(name, password, 0);
		result = "logout.success";
		return result;
	}
}
