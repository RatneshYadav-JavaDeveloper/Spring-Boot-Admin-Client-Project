/**
 * 
 */
package com.usersprofile.UsersProfileMicroServices.utils;

/**
 * @author Ratnesh
 *
 */
public final class ConstantManager {

	//GENERAL CONSTANT MANAGER
	public static final ConstantManager Success = new ConstantManager(200, "success");
	public static final ConstantManager Internal_Server_Error = new ConstantManager(500, "Internal Server Error");
	
	private Integer statusCode;
	private String statusMessage;
	public ConstantManager(Integer statusCode, String statusMessage) {
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
