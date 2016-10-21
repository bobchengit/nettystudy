package com.sdnware.j2se.codec.marshalling;

import java.io.Serializable;

public class SubscribeReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int subReqID;
	
	private String userName;
	
	private String productName;
	
	private String adderss;

	public int getSubReqID() {
		return subReqID;
	}

	public void setSubReqID(int subReqID) {
		this.subReqID = subReqID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAdderss() {
		return adderss;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

	@Override
	public String toString() {
		return "SubscribeReq [subReqID=" + subReqID + ", userName=" + userName + ", productName=" + productName
				+ ", adderss=" + adderss + "]";
	}
	
}
