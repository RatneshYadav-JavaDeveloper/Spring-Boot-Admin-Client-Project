/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.utils;

/**
 * @author Ratnesh
 *
 */
public final class ConstantManager {

	public static final ConstantManager Success = new ConstantManager(200,"Success");
	public static final ConstantManager InternalServerError = new ConstantManager(500, "Internal Server Error"); 
	
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
