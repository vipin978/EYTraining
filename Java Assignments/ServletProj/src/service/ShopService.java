package service;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import model.ShopDAOImpl;
import model.ShopDTO;

public class ShopService {
	
	private static ShopService singleInstance = null; 
	public static ShopService getShopService() {
		if(singleInstance == null) {
			singleInstance = new ShopService();
		}
		return singleInstance;
	}
	
	public ArrayList<ShopDTO> loadDTO(HttpServletRequest request,Enumeration<String> names,String name){
		ShopDAOImpl shopDAO = ShopDAOImpl.getShopDAOImpl(name);
		ArrayList<ShopDTO> dtos = new ArrayList<ShopDTO>();
		while(names.hasMoreElements()) {
			String namee = names.nextElement();
			if(namee.startsWith("img")) {
				String itemName = request.getParameter(namee);
				ShopDTO shopDTO = shopDAO.getShopByName(itemName);
				dtos.add(shopDTO);
			}
		}
		return dtos;
	}
}
