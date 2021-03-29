package model;

import java.io.Serializable;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int uid;
	private String name;
	private int age;
	private String pass;
	private int flag;
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int uid, String uname,int age, String upass, int flag) {
		this.uid = uid;
		this.age = age;
		this.name = uname;
		this.pass = upass;
		this.flag = flag;
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
