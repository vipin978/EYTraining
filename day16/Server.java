package day16;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	ServerSocket ss; Socket s;PrintWriter out;BufferedReader br,in;
	public Server() {
		try {
			ss = new ServerSocket(2000);
			System.out.println("Listening");
			while(true) {
			s = ss.accept();
			
			System.out.println(s);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
