package com.sdnware.j2se.nio;

public class TimeServer {

	public static void main(String[] args) {
		
		int port = 5679;
		if(args != null && args.length > 0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		
		TimeServerHandle multiplexerTimerServer = new TimeServerHandle(port);
		
		new Thread(multiplexerTimerServer,"NIO-multiplexerTimerServer-001").start();

	}

}
