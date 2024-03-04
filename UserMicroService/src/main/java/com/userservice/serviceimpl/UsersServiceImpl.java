package com.userservice.serviceimpl;

import static com.userservice.utils.APPConstants.USERS_STATUS_ACTIVE;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Users;
import com.userservice.model.request.UsersRequestWrapper;
import com.userservice.model.response.StatusDescription;
import com.userservice.model.response.UsersResponseWrapper;
import com.userservice.repo.UsersRepo;
import com.userservice.service.UsersService;
import com.userservice.utils.ConstantManager;

@Service
public class UsersServiceImpl implements UsersService {

	private static final Logger logger = LogManager.getLogger(UsersServiceImpl.class);

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UsersResponseWrapper saveUsersDetails(UsersRequestWrapper requestWrapper) {
		UsersResponseWrapper response = new UsersResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		ResponseEntity<StatusDescription> apiResponse = null;
		try {
			response.setStatusDescription(statusDescription);

			// check users details already exist or not
			Users user = usersRepo.findByMobileNoAndStatus(requestWrapper.getMobileNo(), USERS_STATUS_ACTIVE);
			if (user == null) {
				// save users details here
				Users savedUsers = saveUsers(requestWrapper);

				// calling api to save users contact

				// set request body here
				requestWrapper.setUserId(savedUsers.getId());
				HttpEntity<UsersRequestWrapper> requestBody = new HttpEntity<>(requestWrapper, null);

				apiResponse = restTemplate.exchange("http://localhost:8082/user/v1/save/contact-details",
						HttpMethod.POST, requestBody, StatusDescription.class);

				
				String su = apiResponse.getStatusCode().toString();
				System.out.println("[ RESPONSE CODE : " + su + " ]");
				if ("200 OK".equalsIgnoreCase(su)) {
					response.setSavedUsersContact("OK");
				} else {
					response.setSavedUsersContact("FAILED !!");
				}
				
				
				statusDescription.setStatusCode(ConstantManager.Success.getStatusCode());
				statusDescription.setStatusMessage(ConstantManager.Success.getStatusMessage());

			} else {
				statusDescription.setStatusCode(ConstantManager.User_Already_Exist.getStatusCode());
				statusDescription.setStatusMessage(ConstantManager.User_Already_Exist.getStatusMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public UsersResponseWrapper getUserDetails(UsersRequestWrapper requestWrapper) {
		UsersResponseWrapper response = new UsersResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		try {
			response.setStatusDescription(statusDescription);
			Users user = usersRepo.findByMobileNoAndStatus(requestWrapper.getMobileNo(), USERS_STATUS_ACTIVE);
			if (user != null) {
				response.setUser(user);
				statusDescription.setStatusCode(ConstantManager.Success.getStatusCode());
				statusDescription.setStatusMessage(ConstantManager.Success.getStatusMessage());
			} else {
				statusDescription.setStatusCode(ConstantManager.User_Detail_Not_Found.getStatusCode());
				statusDescription.setStatusMessage(ConstantManager.User_Detail_Not_Found.getStatusMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription.setStatusCode(ConstantManager.Internal_Server_Error.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.Internal_Server_Error.getStatusMessage());
		}

		return response;
	}

	private Users saveUsers(UsersRequestWrapper requestWrapper) {
		Users user = new Users();
		try {

			user.setMobileNo(requestWrapper.getMobileNo());
			user.setStatus(USERS_STATUS_ACTIVE);
			user.setDateTime(new Date());
			user.setUserName(requestWrapper.getUserName());
			user = usersRepo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
