package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ShopDAO;
import com.model.*;

@Service
@Transactional
public class ShopService {
	
	@Autowired
	private ShopDAO shopDAO;

	public final ShopDAO getShopDAO() {
		return shopDAO;
	}

	public final void setShopDAO(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}
	
	public List<ShopDTO> getAllItems(int shopNo) {
		List<ShopDTO> dtos = shopDAO.getAllItem(shopNo);
		return dtos;
	}
	
	public ShopDTO getItemByName(String name) {
		ShopDTO dto = shopDAO.getShopDTO(name);
		return dto;
	}
	
}
