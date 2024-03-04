/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response;

/**
 * @author Ratnesh
 *
 */
public class StatusDescription {

	private Integer statusCode;
	private String statusMessage;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
