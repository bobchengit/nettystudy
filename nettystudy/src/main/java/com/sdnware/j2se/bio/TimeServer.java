package com.sdnware.j2se.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) {
		int port = 5679;
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The Time Server is start in prot :"+port);
			Socket socket = null;
			while(true){
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
