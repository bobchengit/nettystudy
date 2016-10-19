package com.sdnware.j2se.aio;

public class TimeClinet {

	public static void main(String[] args) {

		
		int port = 5679;
		
		AsyncTimerClientTask asyncTimerClientTask = new AsyncTimerClientTask("127.0.0.1",port);
		
		new Thread(asyncTimerClientTask,"NIO-AsyncTimerClientTask-001").start();
		
	}

}
