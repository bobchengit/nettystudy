package com.sdnware.j2se.netty.$4;

import java.io.Serializable;

public class SubscribleResp implements Serializable {

	private static final long serialVersionUID = 1L;

	private int subReqID;
	
	private int respCode;
	
	private String desc;

	public int getSubReqID() {
		return subReqID;
	}

	public void setSubReqID(int subReqID) {
		this.subReqID = subReqID;
	}

	public int getRespCode() {
		return respCode;
	}

	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SubscribleResp [subReqID=" + subReqID + ", respCode=" + respCode + ", desc=" + desc + "]";
	}
}
