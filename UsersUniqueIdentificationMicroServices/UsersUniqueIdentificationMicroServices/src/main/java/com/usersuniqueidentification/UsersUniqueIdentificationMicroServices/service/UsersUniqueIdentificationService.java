/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.service;

import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.request.UsersUniqueIdentificationrequestWrapper;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response.UsersUniqueIdentificationResponseWrapper;

/**
 * @author Ratnesh
 *
 */
public interface UsersUniqueIdentificationService {

	/**
	 * method to save users unique-identifaction details
	 * @param aadharNo
	 * @param userId
	 * **/
	UsersUniqueIdentificationResponseWrapper saveUsersUniqueIdentificationdetails(UsersUniqueIdentificationrequestWrapper requestWrapper);
	
}
