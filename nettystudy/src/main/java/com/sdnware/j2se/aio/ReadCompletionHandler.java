package com.sdnware.j2se.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

	private AsynchronousSocketChannel channel;
	
	
	public ReadCompletionHandler(AsynchronousSocketChannel channel) {
		if(this.channel == null){
			this.channel = channel;
		}
	}

	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] bytes = new byte[attachment.remaining()];
		attachment.get(bytes);
		try {
			String body = new String(bytes,"UTF-8");
			System.out.println("The time server receive order " + body);
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? 
					new java.util.Date(System.currentTimeMillis()).toString() : "BAD";
			doWrite(currentTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void doWrite(String response) {
		if(response != null && response.trim().length() > 0){
			byte[] bytes = response.getBytes();
			ByteBuffer writerBuffer = ByteBuffer.allocate(bytes.length);
			writerBuffer.put(bytes);
			writerBuffer.flip();
			channel.write(writerBuffer,writerBuffer,new CompletionHandler<Integer,ByteBuffer>(){

				public void completed(Integer result, ByteBuffer buffer) {
					if(buffer.hasRemaining()){
						channel.write(buffer,buffer,this);
					}
					
				}

				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			});
		}
		
	}

	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
