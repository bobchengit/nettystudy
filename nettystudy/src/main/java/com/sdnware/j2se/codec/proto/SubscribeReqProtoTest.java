package com.sdnware.j2se.codec.proto;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sdnware.j2se.codec.proto.SubscribeReqProto.SubscribeReq;

public class SubscribeReqProtoTest {
	
	private static byte[] encode(SubscribeReqProto.SubscribeReq req){
		return req.toByteArray();
	}
	
	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException{
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}
	
	private static SubscribeReqProto.SubscribeReq create(){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		
		builder.setAddress("A220");
		builder.setUserName("CH");
		builder.setSubReqID(1);
		builder.setAddress("aaaaaaaaa");
		return builder.build();
	}
	
	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubscribeReqProto.SubscribeReq req = create();
		
		System.out.println("before encode:"+req.toString());
		SubscribeReq req2 = decode(encode(req));
		System.out.println("after encode:"+req2);
		System.out.println("is Equal ："+req.equals(req2));
	}

}
