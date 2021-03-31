package model;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoadDBAction")
public class LoadDBAction extends HttpServlet {
	public LoadDBAction() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String table = (String)request.getAttribute("table");
		System.out.println(table);
		ShopDAOImpl shopDAO = ShopDAOImpl.getShopDAOImpl(table);
		ArrayList<ShopDTO> shopDTOs = shopDAO.getAllItem(); 
		request.setAttribute("items", shopDTOs);
		System.out.println(shopDTOs);
		RequestDispatcher rd = request.getRequestDispatcher(table+".jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
