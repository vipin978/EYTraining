package soapDemo2;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:3000/ws/hello?wsdl");
		QName qname = new QName("http://soapDemo2/", "HelloImplService");
		
		Service service = Service.create(url, qname);
		Hello hservice = service.getPort(Hello.class);
		
		hservice.sayHello();
		System.out.println("in client");
		
	}
}
