package day16Proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	
	Socket s;BufferedReader keyboard,serverMsg;PrintWriter out;String serverTyped,clientTyped=""; 
	public Client() {
		try {
			s = new Socket("localhost",2000);
			serverMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(),true);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[CLIENT] : Connected with Server");
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.execute(()->{
			while(true) {
			try {
				serverTyped = serverMsg.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(serverTyped);
			}
		});
		while(true) {
			try {
			if(clientTyped.equals("QUIT")) {
				out.close();
				serverMsg.close();
				break;
			}
			clientTyped = keyboard.readLine();
			if(!clientTyped.equals("QUIT")) {
			out.println(clientTyped);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
