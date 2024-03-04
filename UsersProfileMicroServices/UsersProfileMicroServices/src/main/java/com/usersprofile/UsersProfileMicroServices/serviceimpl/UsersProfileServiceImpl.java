/**
 * 
 */
package com.usersprofile.UsersProfileMicroServices.serviceimpl;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersprofile.UsersProfileMicroServices.entities.UsersProfile;
import com.usersprofile.UsersProfileMicroServices.model.request.UsersProfileRequestWrapper;
import com.usersprofile.UsersProfileMicroServices.model.response.StatusDescription;
import com.usersprofile.UsersProfileMicroServices.model.response.UsersProfileResponseWrapper;
import com.usersprofile.UsersProfileMicroServices.repo.UsersProfileRepo;
import com.usersprofile.UsersProfileMicroServices.service.UsersProfileService;
import com.usersprofile.UsersProfileMicroServices.utils.ConstantManager;

/**
 * @author Ratnesh
 *
 */
@Service
public class UsersProfileServiceImpl implements UsersProfileService {

	private static final Logger logger = LogManager.getLogger(UsersProfileServiceImpl.class);

	@Autowired
	UsersProfileRepo usersProfileRepo;

	@Override
	public UsersProfileResponseWrapper saveUsersProfileDetails(UsersProfileRequestWrapper requestWrapper) {
		UsersProfileResponseWrapper response = new UsersProfileResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		try {
			response.setStatusDescription(statusDescription);
			//save users-profile details here
			System.out.println("[ REQUEST FROM : "+requestWrapper+"]");
			saveUsersProfile(requestWrapper);
			statusDescription.setStatusCode(ConstantManager.Success.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.Success.getStatusMessage());
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription.setStatusCode(ConstantManager.Internal_Server_Error.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.Internal_Server_Error.getStatusMessage());
		}
		return response;
	}

	private UsersProfile saveUsersProfile(UsersProfileRequestWrapper requestWrapper) {
		UsersProfile up = new UsersProfile();
		try {
			up.setDateTime(new Date());
			up.setId(requestWrapper.getUserId());
			up.setUserProfile(requestWrapper.getUserProfile());
			up=usersProfileRepo.save(up);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return up;
	}

}
