package controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.LoginService;


@WebListener
public class SessionListener implements HttpSessionListener {
	
	public SessionListener() {
		System.out.println("created");
		// TODO Auto-generated constructor stub
	}

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session Created");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session Destroyed");
    	HttpSession session = se.getSession();
		String name = (String)session.getAttribute("name");
		String password = (String)session.getAttribute("password");
		if(name != null && password != null) {
			LoginService service = LoginService.getLoginService();
			service.updateFlag(name, password, 0);
		}
		
    }
	
}
