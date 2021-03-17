package day19;

import java.io.Serializable;
import java.sql.Date;
//import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int inv_no;
	private Date inv_date;
	private int customer_no;
	
	public int getInv_no() {
		return inv_no;
	}
	public void setInv_no(int inv_no) {
		this.inv_no = inv_no;
	}
	
	public Date getInv_date() {
		return inv_date;
	}
	
	public void setInv_date(Date inv_date) {
		this.inv_date = inv_date;
	}
	
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	
	@Override
		public String toString() {
			return "InvoiceMaterDTO [ "+inv_no +", "+inv_date + ", "+customer_no+" ]";
		}
	
}
