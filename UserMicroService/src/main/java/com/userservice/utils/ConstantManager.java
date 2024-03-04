package com.userservice.utils;

public class ConstantManager {

	private Integer statusCode;
	private String statusMessage;

	// General Status Code
	public final static ConstantManager Success = new ConstantManager(200, "Success");
	public final static ConstantManager Internal_Server_Error = new ConstantManager(500, "Internal Server Error");

	
	//user releated status code 
	public static final ConstantManager User_Detail_Not_Found = new ConstantManager(600, "User Detail Not Found");
	public static final ConstantManager User_Already_Exist = new ConstantManager(601, "User Already Exist");
	
	public ConstantManager(Integer statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

}
