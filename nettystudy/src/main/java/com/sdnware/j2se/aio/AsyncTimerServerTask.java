package com.sdnware.j2se.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimerServerTask implements Runnable {

	CountDownLatch latch;
	
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsyncTimerServerTask(int port){
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("listen port :"+port);
		} catch (IOException e) {
		}
		
	}
	
	
	
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}



	public void doAccept() {
		
		asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
		
	}

}
