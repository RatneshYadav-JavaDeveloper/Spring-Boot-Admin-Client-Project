package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.model.request.UsersRequestWrapper;
import com.userservice.model.response.StatusDescription;
import com.userservice.model.response.UsersResponseWrapper;
import com.userservice.service.UsersService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired UsersService usersService;
	
	/**
	 * controller to save users details
	 * @param name
	 * @param msisdn
	 * @param usersProfile
	 * @param usersAddress
	 * @param usersAadharCardNo
	 * 
	 * **/
	@PostMapping(value = "/v1/save/users-detail")
	public ResponseEntity<UsersResponseWrapper> saveUsersDetails(@RequestBody UsersRequestWrapper requestWrapper)
	{
		UsersResponseWrapper response = new UsersResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		response.setStatusDescription(statusDescription);
		
		response = usersService.saveUsersDetails(requestWrapper);
		return new ResponseEntity<UsersResponseWrapper>(response,HttpStatus.OK);
		
	}
}