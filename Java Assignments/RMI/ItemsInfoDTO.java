package day19;

import java.io.Serializable;

public class ItemsInfoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int item_no;
	private String item_desp;
	private int item_price;
	private int item_qty;
	
	public int getItem_no() {
		return item_no;
	}
	
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	
	public String getItem_desp() {
		return item_desp;
	}
	
	public void setItem_desp(String item_desp) {
		this.item_desp = item_desp;
	}
	
	public int getItem_price() {
		return item_price;
	}
	
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	
	public int getItem_qty() {
		return item_qty;
	}
	
	public void setItem_qty(int item_qty) {
		this.item_qty = item_qty;
	}
}
