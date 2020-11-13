package com.java.constants;

/*This enum class is used for sending the error code and message*/

public enum ServiceMessage {
	
	SUCCESS_RESPONSE("E200","Success"),
	INVALIDSTATECODE("E202","State code is not valid "),
	INTERNALSERVERERROR("E205","Internal server error"),
	NO_RECORD_FOUND("E0030","No record found."),
	CLIENT_VALIDATION_FAILED("E1001","Clent validation failed");
	 private final String code;
	  private final String message;

	  ServiceMessage(String code, String message) {
	     this.code= code;
	     this.message = message;
	  }

	  public String getCode() {
		  return code; 
	  }
	  
	  public String getMessage() {
		  return message; 
	  }
	

}
