package com.sdnware.j2se.nio;

public class TimeClient {

	public static void main(String[] args) {
		
		int port = 5679;
		if(args != null && args.length > 0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		
		TimeClientHandle clientHandle = new TimeClientHandle("127.0.0.1", port);
		
		new Thread(clientHandle,"NIO-Clinet-001").start();

	}

}
