package day16Proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
	
	Socket clientSocket;PrintWriter clientOut;BufferedReader clientIn;
	int clientIdx;
	String clientName;
	
	public ClientHandler(Socket s) throws Exception {
		this.clientSocket = s;
		System.out.println(clientSocket);
		this.clientOut = new PrintWriter(this.clientSocket.getOutputStream(),true);
		this.clientIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
	}
	
	@Override
	public void run() {
		clientOut.println("[SERVER] : HEY THIS IS A SERVICE PROVIDED BY ME TELL ME YOUR NAME..");
		try {
			clientName = clientIn.readLine();
			Server.clients.put(clientName, this);
		} catch (IOException e1) {
			System.out.println("CLOSING THE CONNECTION");
			return ;
		}
		while(true) {
			try {
				clientOut.println("[SERVER] : ENTER AN INDEX TO VIEW DATA");
				String m = clientIn.readLine();
				clientIdx = Integer.parseInt(m)%5;
				System.out.println(clientIdx);
				clientOut.println("[SERVER] : THE DATA YOU ARE LOOKING FOR "+Server.data.get(clientIdx));
			}catch (Exception e) {
				System.out.println("[SERVER] : CLOSING CLIENT CONNECTION");
				break;
			}	
//			}finally {
//				Server.clients.remove(clientName);
//				clientOut.close();
//				try {
//					clientIn.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
		}
		
	}
}
