package soapDemo2;

import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class Handler implements SOAPHandler<SOAPMessageContext>{

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Handle message called");
		try {
		SOAPMessage sm = context.getMessage();
		PrintStream out = new PrintStream(System.out);
		sm.writeTo(out);
		out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Fault occurs");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("req or res closed");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Hedears called");
		return null;
	}
	
}
