package com.sdnware.j2se.codec.proto;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {
	

	
	public SubReqClientHandler(){}
	
	public SubscribeReqProto.SubscribeReq subscribeReq(int i){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		
		builder.setAddress("A220");
		builder.setProductName("A220 MAN");
		builder.setSubReqID(i);
		builder.setUserName("CHENB");
		return builder.build();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		for(int i=1;i<10;i++){
			ctx.write(subscribeReq(i));
		}
		ctx.flush();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		System.out.println("Read Server response [" + (SubscribeRespProto.SubscribeResp.newBuilder().getRespCode()+"]"));
		
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
