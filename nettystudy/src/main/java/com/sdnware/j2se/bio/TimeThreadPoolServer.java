package com.sdnware.j2se.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeThreadPoolServer {
	


	public static void main(String[] args) {
		int port = 5679;
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The Time Server is start in prot :"+port);
			Socket socket = null;
			TimeServerHandlerExxcutePool singleExecutor = new TimeServerHandlerExxcutePool(50,10000);
			while(true){
				socket = server.accept();
				singleExecutor.execute((new TimeServerHandler(socket)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
