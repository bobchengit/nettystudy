package com.sdnware.j2se.codec.pojo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class UserInfoSpeedTest {

	public static void main(String[] args) throws IOException {

		UserInfo userInfo = new UserInfo();
		userInfo.buildUserID(100).buildUserName("Welcome to Netty");
		int loop = 10000000;
		long s = System.currentTimeMillis();
		for(int i =0;i<loop;i++){
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(userInfo);
			os.flush();
			os.close();
			bos.toByteArray();
			bos.close();
		}
		long e = System.currentTimeMillis();
		System.out.println("java serializable:"+(e-s));
		
		s=System.currentTimeMillis();
		for(int i =0;i<loop;i++){
			userInfo.codeC();
		}
		e=System.currentTimeMillis();;
		
		System.out.println("byte serializable:"+(e-s));
		
	}

}
