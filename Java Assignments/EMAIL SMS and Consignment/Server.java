package day16Proj;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	ServerSocket ss; Socket s;
	ExecutorService pool = Executors.newFixedThreadPool(5);
	public static ArrayList<String> data = new ArrayList<String>(Arrays.asList("Hey","Hi","Hello","Gb"));  
	public static HashMap<String, ClientHandler> clients= new HashMap<>();
	
	public Server() {
		try {
			ss = new ServerSocket(2000);
			while(true) {
				System.out.println("[SERVER] : Listening");
				s = ss.accept();
				System.out.println("[SERVER] : New Client Connected");
				ClientHandler ch = new ClientHandler(s);
				pool.execute(ch);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			clients = null;
			data = null;
			pool.shutdown();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
