package com.java.exception;

public class InvalidPayloadException extends RuntimeException {

	public InvalidPayloadException(String str)
	{
		super(str);
	}
}
