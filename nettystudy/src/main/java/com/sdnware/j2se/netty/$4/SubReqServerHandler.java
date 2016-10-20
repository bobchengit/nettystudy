package com.sdnware.j2se.netty.$4;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqServerHandler extends ChannelHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		SubscribeReq req = (SubscribeReq)msg;
		System.out.println(req.toString());
		ctx.writeAndFlush(resp(req.getSubReqID()));
	}

	private SubscribleResp resp(int subReqID) {
		SubscribleResp resp = new SubscribleResp();
		resp.setSubReqID(subReqID);
		resp.setRespCode(0);
		resp.setDesc("hello S");
		return resp;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		
		cause.printStackTrace();
		ctx.close();
	}

}
