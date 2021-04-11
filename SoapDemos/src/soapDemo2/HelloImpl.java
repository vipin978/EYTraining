package soapDemo2;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "soapDemo2.Hello")
@HandlerChain(file = "soapDemo2/handler-chain.xml")
public class HelloImpl implements Hello{
	
	@Override
	@WebMethod
	public void sayHello() {
		System.out.println("hey from soap service");
	}
}
