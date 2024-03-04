package com.userservice.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.userservice.entities.Users;

@JsonSerialize(include = Inclusion.NON_NULL)
public class UsersResponseWrapper {

	private StatusDescription statusDescription;

	private Users user;
	
	private String savedUsersContact;
	private String savedUsersProfile;
	private String savedUsersUniqueIdentification;

	public StatusDescription getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(StatusDescription statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getSavedUsersContact() {
		return savedUsersContact;
	}

	public void setSavedUsersContact(String savedUsersContact) {
		this.savedUsersContact = savedUsersContact;
	}

	public String getSavedUsersProfile() {
		return savedUsersProfile;
	}

	public void setSavedUsersProfile(String savedUsersProfile) {
		this.savedUsersProfile = savedUsersProfile;
	}

	public String getSavedUsersUniqueIdentification() {
		return savedUsersUniqueIdentification;
	}

	public void setSavedUsersUniqueIdentification(String savedUsersUniqueIdentification) {
		this.savedUsersUniqueIdentification = savedUsersUniqueIdentification;
	}
	
	

}
