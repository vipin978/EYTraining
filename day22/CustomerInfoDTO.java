package day19;

import java.io.Serializable;

public class CustomerInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int customer_no;
	private String customer_address;
	private String customer_email;
	private String customer_phone;
	
	
	public int getCustomer_no() {
		return customer_no;
	}


	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}


	public String getCustomer_address() {
		return customer_address;
	}


	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}


	public String getCustomer_email() {
		return customer_email;
	}


	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}


	public String getCustomer_phone() {
		return customer_phone;
	}


	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}


	@Override
		public String toString() {
			return "InvoiceMaterDTO [ "+customer_no +", "+customer_address + ", "+ customer_email + ", "+ customer_phone+" ]";
		}
}
