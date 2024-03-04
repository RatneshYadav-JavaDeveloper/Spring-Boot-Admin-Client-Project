/**
 * 
 */
package com.userscontact.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * @author Ratnesh
 *
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class UsersContactResponseWrapper {

	private StatusDescription statusDescription;

	private String savedUsersProfile;

	public StatusDescription getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(StatusDescription statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getSavedUsersProfile() {
		return savedUsersProfile;
	}

	public void setSavedUsersProfile(String savedUsersProfile) {
		this.savedUsersProfile = savedUsersProfile;
	}

}
