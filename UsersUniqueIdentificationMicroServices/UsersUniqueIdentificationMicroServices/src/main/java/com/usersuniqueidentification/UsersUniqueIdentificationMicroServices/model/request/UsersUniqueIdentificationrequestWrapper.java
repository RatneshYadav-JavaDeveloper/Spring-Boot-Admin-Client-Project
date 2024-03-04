/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.request;

/**
 * @author Ratnesh
 *
 */
public class UsersUniqueIdentificationrequestWrapper {

	private Long userId;
	private String aadharCardNo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAadharCardNo() {
		return aadharCardNo;
	}

	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
	}

}
