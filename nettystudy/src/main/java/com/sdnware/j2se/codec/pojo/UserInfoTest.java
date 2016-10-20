package com.sdnware.j2se.codec.pojo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserInfoTest {

	public static void main(String[] args) throws IOException {

		UserInfo userInfo = new UserInfo();
		userInfo.buildUserID(100).buildUserName("Welcome to Netty");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(userInfo);
		os.flush();
		os.close();
		byte[] b = bos.toByteArray();
		
		System.out.println("java Serializable:"+b.length);
		
		bos.close();
		
		System.out.println("byte serializable:"+userInfo.codeC().length);
		
	}

}
