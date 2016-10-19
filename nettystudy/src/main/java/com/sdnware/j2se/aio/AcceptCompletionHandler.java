package com.sdnware.j2se.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler
		implements CompletionHandler<AsynchronousSocketChannel, AsyncTimerServerTask> {

	public void completed(AsynchronousSocketChannel result, AsyncTimerServerTask attachment) {
		
		attachment.asynchronousServerSocketChannel.accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer,buffer,new ReadCompletionHandler(result));
		
	}

	public void failed(Throwable exc, AsyncTimerServerTask attachment) {
		exc.printStackTrace();
		attachment.latch.countDown();
	}

}
