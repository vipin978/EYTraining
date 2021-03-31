package controller;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcess {
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {    
			ServletContext application=request.getServletContext();
			String path=(String)application.getAttribute("path");
			Properties prop=new Properties();
			prop.load(new FileInputStream(path));
			String id;

			id = request.getParameter("id");
	
			if(id == null) {
				System.out.println("id is Null");
			}
			else {
				if(id.equals("shopAction")) {	
					if(request.getParameter("action").equals("Logout")) {
						id = "Logout";	
					}
				}
				System.out.println("1");
				String className = prop.getProperty(id);
				System.out.println("2");
				model.Action action= (model.Action)Class.forName(className).getConstructor().newInstance();
				String result = action.execute(request, response);
				System.out.println("3");
				String page = prop.getProperty(result);
				request.setAttribute("table", result);
				System.out.println(result);
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
