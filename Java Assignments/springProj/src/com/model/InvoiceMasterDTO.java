package com.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "getAll" ,query = "from InvoiceMasterDTO"),
	@NamedQuery(name = "getByUserId" ,query = "from InvoiceMasterDTO where user = ?")
})
public class InvoiceMasterDTO {
	@Id @GeneratedValue
	private int inv_no;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDTO user; 
	
	public int getInv_no() {
		return inv_no;
	}
	public void setInv_no(int inv_no) {
		this.inv_no = inv_no;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public UserDTO getUser() {
		return this.user;
	}
	public void setUser(UserDTO user) {
		user.getInvoices().add(this);
		this.user = user;
	}
	
}
