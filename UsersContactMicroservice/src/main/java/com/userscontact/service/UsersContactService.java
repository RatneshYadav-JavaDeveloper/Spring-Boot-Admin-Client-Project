/**
 * 
 */
package com.userscontact.service;

import com.userscontact.model.request.UsersContactRequestWrapper;
import com.userscontact.model.response.UsersContactResponseWrapper;

/**
 * @author Ratnesh
 *
 */
public interface UsersContactService {

	/**
	 * method to save users contact details 
	 * @param address
	 * @param landmark
	 * @param userId
	 * **/
	UsersContactResponseWrapper saveUsersContactDetails(UsersContactRequestWrapper requestWrapper);
}
