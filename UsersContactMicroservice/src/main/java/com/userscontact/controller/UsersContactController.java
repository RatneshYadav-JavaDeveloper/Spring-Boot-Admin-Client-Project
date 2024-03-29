/**
 * 
 */
package com.userscontact.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userscontact.model.request.UsersContactRequestWrapper;
import com.userscontact.model.response.StatusDescription;
import com.userscontact.model.response.UsersContactResponseWrapper;
import com.userscontact.service.UsersContactService;

/**
 * @author Ratnesh
 *
 */
@RestController
@RequestMapping("/user")
public class UsersContactController {

	private static final Logger logger = LogManager.getLogger(UsersContactController.class);
	
	@Autowired UsersContactService usersContactService;

	@PostMapping(value = "/v1/save/contact-details")
	public ResponseEntity<UsersContactResponseWrapper> saveUsersContactDetails(
			@RequestBody UsersContactRequestWrapper requestWrapper) {
		
		UsersContactResponseWrapper response = new UsersContactResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		response.setStatusDescription(statusDescription);
		response = usersContactService.saveUsersContactDetails(requestWrapper);
		return new ResponseEntity<UsersContactResponseWrapper>(response, HttpStatus.OK);

	}
}
