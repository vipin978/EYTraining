package model;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LanguageAction extends Action{
	
	public LanguageAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String language = request.getParameter("language");
		
		ResourceBundle bundle = ResourceBundle.getBundle("model.Dictionary", new Locale(language));
		
		HttpSession session = request.getSession();
		session.setAttribute("rb", bundle);
		return "language.success";
	}
}
