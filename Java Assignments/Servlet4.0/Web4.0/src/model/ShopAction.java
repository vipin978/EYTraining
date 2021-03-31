package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShopService;

public class ShopAction extends Action{
	
	public ShopAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		Enumeration<String> names = request.getParameterNames();
		
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("items");
		
		ShopService service = ShopService.getShopService();
		
		if(obj == null) {
			ArrayList<ShopDTO> items = service.loadDTO(request,names,request.getParameter("current"));  
			session.setAttribute("items", items);
		}
		else {
			ArrayList<ShopDTO> items = (ArrayList<ShopDTO>) session.getAttribute("items");
			items.addAll(service.loadDTO(request,names,request.getParameter("current")));
		}
		
		System.out.println(session.getAttribute("items") + "itemssssss");
		if(request.getParameter("action").equals("BuyNow")) {
			return "final";
		}
		return request.getParameter("next");
	}
	
}
