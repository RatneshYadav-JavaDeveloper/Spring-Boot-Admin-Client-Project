package com.userservice.service;

import com.userservice.model.request.UsersRequestWrapper;
import com.userservice.model.response.UsersResponseWrapper;

public interface UsersService {

	/**
	 * method to save users details
	 * @param name
	 * @param msisdn
	 * @param address
	 * @param usersProfile
	 * @param aadharCardNo
	 * **/
	UsersResponseWrapper saveUsersDetails(UsersRequestWrapper requestWrapper);
	
	/**
	 * method to get users details by msisdn
	 * @param msisdn
	 * 
	 * **/
	UsersResponseWrapper getUserDetails(UsersRequestWrapper requestWrapper);
	
}
