/**
 * 
 */
package com.userscontact.model.request;

/**
 * @author Ratnesh
 *
 */
public class UsersContactRequestWrapper {

	private String address;
	private String landMark;
	private Long userId;
	private String userProfile;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

}
