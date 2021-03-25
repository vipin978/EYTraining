package mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcess {
	
	
	public void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Properties props = new Properties();
		props.load(new FileInputStream("C:/Users/user/eclipse-workspace/config.properties"));
		if(props.getProperty(id) == null) {
			System.out.println(id);
		}else {
			try {
				String className = props.getProperty(id).toString();
				Action action = (Action)Class.forName(className).getConstructor().newInstance();
				String result = action.execute(request, response);
				System.out.println(result);
				String name = null;
//				String password = null;
				
				if(result.startsWith("Login.welcome")) {
					String[] tokens=result.split("/"); 
					result = tokens[0];
					name = tokens[1];
				}
				
				String page = props.getProperty(result);
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				if(page.equals("welcome1.jsp")) {
					request.setAttribute("name", name);
//					request.setAttribute("password", password);
				}
				
				dispatcher.forward(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
