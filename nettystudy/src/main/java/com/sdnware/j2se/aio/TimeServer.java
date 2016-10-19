package com.sdnware.j2se.aio;

public class TimeServer {

	public static void main(String[] args) {

		
		int port = 5679;
		
		AsyncTimerServerTask asyncTimerServerTask = new AsyncTimerServerTask(port);
		
		new Thread(asyncTimerServerTask,"NIO-AsyncTimerServerTask-001").start();
		
	}

}
