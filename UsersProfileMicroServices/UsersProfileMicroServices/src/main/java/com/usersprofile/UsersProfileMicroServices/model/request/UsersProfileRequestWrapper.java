/**
 * 
 */
package com.usersprofile.UsersProfileMicroServices.model.request;

/**
 * @author Ratnesh
 *
 */
public class UsersProfileRequestWrapper {

	private Long userId;
	private String userProfile;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public String toString() {
		return "UsersProfileRequestWrapper [userId=" + userId + ", userProfile=" + userProfile + "]";
	}
	
	

}
