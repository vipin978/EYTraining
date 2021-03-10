package day16;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	Socket s;BufferedReader br,in;PrintWriter out;
	public Client() {
		try {
		s = new Socket("localhost",2000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
