package soapDemo2;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Hello {
	@WebMethod
	public void sayHello();
}
