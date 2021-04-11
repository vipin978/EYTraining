package soapDemo2;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:3000/ws/hello", new HelloImpl());
		System.out.println("published");
	}
}
