package day19;

import java.io.Serializable;

public class ItemsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 14L;
	private int inv_no;
	private int item_no;
	private int item_unt;
	
	public int getInv_no() {
		return inv_no;
	}
	
	public void setInv_no(int inv_no) {
		this.inv_no = inv_no;
	}
	
	public int getItem_no() {
		return item_no;
	}
	
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	
	public int getItem_unt() {
		return item_unt;
	}
	
	public void setItem_unt(int item_unt) {
		this.item_unt = item_unt;
	}
	
	
}
