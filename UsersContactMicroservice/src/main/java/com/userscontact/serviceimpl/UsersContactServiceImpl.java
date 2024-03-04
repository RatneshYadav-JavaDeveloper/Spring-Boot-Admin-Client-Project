/**
 * 
 */
package com.userscontact.serviceimpl;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userscontact.entities.UsersContact;
import com.userscontact.model.request.UsersContactRequestWrapper;
import com.userscontact.model.response.StatusDescription;
import com.userscontact.model.response.UsersContactResponseWrapper;
import com.userscontact.repo.UsersContactRepo;
import com.userscontact.service.UsersContactService;
import com.userscontact.utils.ConstantManager;

/**
 * @author Ratnesh
 *
 */
@Service
public class UsersContactServiceImpl implements UsersContactService {

	private static final Logger logger = LogManager.getLogger(UsersContactServiceImpl.class);

	@Autowired
	UsersContactRepo usersContactRepo;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UsersContactResponseWrapper saveUsersContactDetails(UsersContactRequestWrapper requestWrapper) {
		UsersContactResponseWrapper response = new UsersContactResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();

		try {
			response.setStatusDescription(statusDescription);
			// save users contact details here
			saveUsersContact(requestWrapper);

			// calling api to save users profile
			HttpEntity<UsersContactRequestWrapper> requestBody = new HttpEntity<>(requestWrapper, null);
			ResponseEntity<StatusDescription> apiResponse = restTemplate.exchange(
					"http://localhost:8083/user/v1/save/users-profile", HttpMethod.POST, requestBody,
					StatusDescription.class);

			if ("200 OK".equalsIgnoreCase(apiResponse.getStatusCode().toString())) {
				response.setSavedUsersProfile("OK");
			} else {
				response.setSavedUsersProfile("Failed !!!");
			}

			// calling api to save usersUnique Identification
			statusDescription.setStatusCode(ConstantManager.Success.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.Success.getStatusMessage());

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription.setStatusCode(ConstantManager.Internal_Server_Error.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.Internal_Server_Error.getStatusMessage());
		}
		return response;
	}

	private UsersContact saveUsersContact(UsersContactRequestWrapper requestWrapper) {
		UsersContact usersContact = new UsersContact();
		try {
			usersContact.setAddress(requestWrapper.getAddress());
			usersContact.setDateTime(new Date());
			usersContact.setLandMark(requestWrapper.getLandMark());
			usersContact.setUserId(requestWrapper.getUserId());
			usersContactRepo.save(usersContact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersContact;
	}
}
