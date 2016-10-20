package com.sdnware.j2se.codec.proto;


import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubSeqServerHandler extends ChannelHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq)msg;
		System.out.println(req.toString());
		ctx.writeAndFlush(resp(req.getSubReqID()));
	}

	private SubscribeRespProto.SubscribeResp resp(int subReqID) {
		SubscribeRespProto.SubscribeResp.Builder resp = SubscribeRespProto.SubscribeResp.newBuilder();
		resp.setSubReqID(subReqID);
		resp.setRespCode(200);
		resp.setDesc("Heee");
		return resp.build();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		
		cause.printStackTrace();
		ctx.close();
	}


	
}
