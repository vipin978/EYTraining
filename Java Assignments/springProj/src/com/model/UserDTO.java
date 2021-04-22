package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="UserDTO.getById",query="from UserDTO where uid = ?"),
	@NamedQuery(name="UserDTO.getByName",query="from UserDTO where name = ? and pass = ?")
})
public class UserDTO {
	@Id @GeneratedValue
	private int uid;
	private String name;
	private int age;
	private String pass;
	private int flag;
	@OneToMany(mappedBy = "user")
	private List<InvoiceMasterDTO> invoices = new ArrayList<InvoiceMasterDTO>();
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String uname,int age, String upass, int flag) {
		this.age = age;
		this.name = uname;
		this.pass = upass;
		this.flag = flag;
	}
	public List<InvoiceMasterDTO> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<InvoiceMasterDTO> invoices) {
		this.invoices = invoices;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
