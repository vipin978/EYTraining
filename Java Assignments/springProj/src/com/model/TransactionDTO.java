package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "getbyInvoiceId",query = "from TransactionDTO where invoice_id = ?")
})
public class TransactionDTO {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	int transaction_no;
	
	private int item_no;
	
	private int invoice_id;
	
	
	int quantity = 1;
	
	public int getItem_no() {
		return item_no;
	}


	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}


	public int getInvoice_id() {
		return invoice_id;
	}


	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}


	public final int getQuantity() {
		return quantity;
	}


	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
}

