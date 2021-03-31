package service;

import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.ShopDTO;

interface DetailsLoader{
	public abstract DetailsLoader addItem(List<String> v);
}


public class CustomerData implements Serializable{
	
	private static final long serialVersionUID = 12L;
	public String name;
	public int BillNo;
	public Date date;
	public List<ShopDTO> items = new ArrayList<ShopDTO>();

	public CustomerData() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerData(String name,int BillNo,Date date) {
		this.name = name;
		this.BillNo = BillNo;
		this.date = date;
	}
	
}