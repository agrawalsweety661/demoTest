package com.java.model;

public class ErrorBean {
	private String code ="";
	private String message="";
	
	public ErrorBean(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ErrorBean()
	{}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorBean [code=" + code + ", message=" + message + "]";
	}
	
	
	

}
