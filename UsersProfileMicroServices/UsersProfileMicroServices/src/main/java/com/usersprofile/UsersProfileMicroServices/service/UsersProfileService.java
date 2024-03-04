/**
 * 
 */
package com.usersprofile.UsersProfileMicroServices.service;

import com.usersprofile.UsersProfileMicroServices.model.request.UsersProfileRequestWrapper;
import com.usersprofile.UsersProfileMicroServices.model.response.UsersProfileResponseWrapper;

/**
 * @author Ratnesh
 *
 */
public interface UsersProfileService {

	/**
	 * method to save users-profile details
	 * @param userProfile
	 * @param userId
	 * 
	 * **/
	UsersProfileResponseWrapper saveUsersProfileDetails(UsersProfileRequestWrapper requestWrapper);
}
