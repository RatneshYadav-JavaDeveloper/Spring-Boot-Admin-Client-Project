package com.userscontact.utils;

public class ConstantManager {

	private Integer statusCode;
	private String statusMessage;
	
	
	//GENERAL CONSTANT MANAGER
	public static final ConstantManager Success = new ConstantManager(200, "Success");
	public static final ConstantManager Internal_Server_Error = new ConstantManager(500, "Internal Server Error");

	
	
	public Integer getStatusCode() {
		return statusCode;
	}


	public String getStatusMessage() {
		return statusMessage;
	}


	public ConstantManager(Integer statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	
	
}
