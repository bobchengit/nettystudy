package com.sdnware.j2se.netty.$4;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {
	
	public SubReqClientHandler(){}
	
	public SubscribeReq subscribeReq(int i){
		SubscribeReq req = new SubscribeReq();
		req.setAdderss("A220");
		req.setProductName("A220 MAN");
		req.setSubReqID(i);
		req.setUserName("CHENB");
		return req;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(int i=0;i<10;i++){
			ctx.write(subscribeReq(i));
		}
		ctx.flush();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		System.out.println("Read Server response" + msg);
		
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}
