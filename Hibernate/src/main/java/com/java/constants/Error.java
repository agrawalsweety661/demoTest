package com.java.constants;


public enum Error {

	FAIL(0),
	SUCCESS(1);
	int code;

	private Error(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	
}
   