package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ActionServlet",
        description = "MyDescription",
        urlPatterns = {"/ActionServlet"},
        initParams={
            @WebInitParam(name = "config",value = "/WEB-INF/config.properties")
        }
    )
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	RequestProcess rp = new RequestProcess();
	
	@Override
		public void init(ServletConfig config) throws ServletException {
			String file = config.getInitParameter("config");
			String path = config.getServletContext().getRealPath(file);
			System.out.println(path + "  "+file);
			config.getServletContext().setAttribute("path", path);
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setMaxInactiveInterval(30);
		System.out.println("called doGet");
		rp.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
