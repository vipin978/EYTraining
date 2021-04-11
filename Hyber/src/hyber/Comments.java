package hyber;

import java.io.Serializable;

public class Comments implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String msg;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(String msg) {
		this.msg = msg;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
