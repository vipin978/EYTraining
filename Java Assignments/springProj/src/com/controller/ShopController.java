package com.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.pdf.AcroFields.Item;
import com.model.ShopDTO;
import com.service.ShopService;

@Controller
@RequestMapping("shop")
public class ShopController {

	@Autowired
	private ShopService shopServ;
		
	public ShopService getShopServ() {
		return shopServ;
	}

	public void setShopServ(ShopService shopServ) {
		this.shopServ = shopServ;
	}
	
	ItemList list = new ItemList();
	PurchaseList purchased = new PurchaseList();
	List<String> purchasedS = new ArrayList<String>();
	
	@RequestMapping("shop1")
	public ModelAndView myShop1(ModelAndView mv) {
		List<ShopDTO> dtos = shopServ.getAllItems(1);
		mv.addObject("items", dtos);
		mv.addObject("list", list);
		mv.setViewName("shop1");
		return mv;
	}
	
	@RequestMapping(value = "shop2",method=RequestMethod.POST)
	public ModelAndView myShop2(ItemList list,ModelAndView mv) {
		System.out.println(list.getItemlist().get(0));
		for(String s:list.getItemlist()) {
			purchasedS.add(s);
		}
		List<ShopDTO> dtos = shopServ.getAllItems(2);
		mv.addObject("items", dtos);
		mv.addObject("list", list);
		mv.addObject("purchased", purchasedS);
		mv.setViewName("shop2");
		return mv;
	}
	
	@RequestMapping(value = "shop3",method=RequestMethod.POST)
	public ModelAndView myShop3(ItemList list,ModelAndView mv) {
		System.out.println(list);
		for(String s:list.getItemlist()) {
			purchasedS.add(s);
		}
		List<ShopDTO> dtos = shopServ.getAllItems(3);
		mv.addObject("items", dtos);
		mv.addObject("list", list);
		mv.addObject("purchased", purchasedS);
		mv.setViewName("shop3");
		return mv;
	}
	
	@RequestMapping(value = "getemail",method=RequestMethod.POST)
	public ModelAndView getmail(ItemList list,ModelAndView mv,HttpServletRequest request) throws Exception{
		for(String s:list.getItemlist()) {
			purchasedS.add(s);
		}
		HttpSession session = request.getSession();
		for(String s:purchasedS) {
			purchased.purchaseItems.add(shopServ.getItemByName(s));
		}
		session.setAttribute("purchased", purchased.purchaseItems);
		mv.setViewName("getemail");
		return mv;
	}
	
}


class ItemList{
	private List<String> itemlist;

	public List<String> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<String> itemlist) {
		this.itemlist = itemlist;
	}
}	


class PurchaseList{
	public List<ShopDTO> purchaseItems = new ArrayList<ShopDTO>();

	public final List<ShopDTO> getPurchaseItems() {
		return purchaseItems;
	}

	public final void setPurchaseItems(List<ShopDTO> purchaseItems) {
		purchaseItems.addAll(purchaseItems);
	}
}	