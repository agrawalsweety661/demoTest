package com.java.exception;

/**
 * @Developer: Rajesh Rawat
 * @author ICEGATE
 * @date: 14-03-2019
 * @description: This class is responsible for Exception message for system data not found
 * 
 */
public class SystemConfigurationException extends InvalidPayloadException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemConfigurationException(String message) {
		super(message);
		
	}

}
