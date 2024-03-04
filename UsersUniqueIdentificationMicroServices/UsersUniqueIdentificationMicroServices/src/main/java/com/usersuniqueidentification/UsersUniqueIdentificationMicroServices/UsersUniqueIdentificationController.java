/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.request.UsersUniqueIdentificationrequestWrapper;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response.StatusDescription;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response.UsersUniqueIdentificationResponseWrapper;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.service.UsersUniqueIdentificationService;

/**
 * @author Ratnesh
 *
 */
@RestController
@RequestMapping("/user")
public class UsersUniqueIdentificationController {

	private static final Logger logger = LogManager.getLogger(UsersUniqueIdentificationController.class);

	@Autowired
	UsersUniqueIdentificationService usersUniqueIdentificationService;

	public ResponseEntity<UsersUniqueIdentificationResponseWrapper> saveUserUniqueDetails(
			@RequestBody UsersUniqueIdentificationrequestWrapper requestWrapper) {
		UsersUniqueIdentificationResponseWrapper response = new UsersUniqueIdentificationResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		response.setStatusDescription(statusDescription);
		response = usersUniqueIdentificationService.saveUsersUniqueIdentificationdetails(requestWrapper);
		return new ResponseEntity<UsersUniqueIdentificationResponseWrapper>(response, HttpStatus.OK);
	}
}