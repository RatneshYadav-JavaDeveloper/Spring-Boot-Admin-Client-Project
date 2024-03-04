/**
 * 
 */
package com.usersprofile.UsersProfileMicroServices.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usersprofile.UsersProfileMicroServices.model.request.UsersProfileRequestWrapper;
import com.usersprofile.UsersProfileMicroServices.model.response.StatusDescription;
import com.usersprofile.UsersProfileMicroServices.model.response.UsersProfileResponseWrapper;
import com.usersprofile.UsersProfileMicroServices.service.UsersProfileService;

/**
 * @author Ratnesh
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UsersProfileMicroServicesController {

	private static final Logger logger = LogManager.getLogger(UsersProfileMicroServicesController.class);

	@Autowired
	UsersProfileService usersProfileService;

	@PostMapping(value = "/v1/save/users-profile")
	public ResponseEntity<UsersProfileResponseWrapper> saveUsersProfileDetails(
			@RequestBody UsersProfileRequestWrapper requestWrapper) {

		UsersProfileResponseWrapper response = new UsersProfileResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		response.setStatusDescription(statusDescription);
		response = usersProfileService.saveUsersProfileDetails(requestWrapper);
		return new ResponseEntity<UsersProfileResponseWrapper>(response, HttpStatus.OK);
	}

}