/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.serviceImpl;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.entities.UsersUniqueIIdentification;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.request.UsersUniqueIdentificationrequestWrapper;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response.StatusDescription;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response.UsersUniqueIdentificationResponseWrapper;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.repo.UsersUniqueIdentificationRepo;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.service.UsersUniqueIdentificationService;
import com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.utils.ConstantManager;

/**
 * @author Ratnesh
 *
 */
@Service
public class UsersUniqueIdentificationServiceImpl implements UsersUniqueIdentificationService {

	private static final Logger logger = LogManager.getLogger(UsersUniqueIdentificationServiceImpl.class);

	@Autowired
	UsersUniqueIdentificationRepo usersUniqueIdentificationRepo;

	@Override
	public UsersUniqueIdentificationResponseWrapper saveUsersUniqueIdentificationdetails(
			UsersUniqueIdentificationrequestWrapper requestWrapper) {
		UsersUniqueIdentificationResponseWrapper response = new UsersUniqueIdentificationResponseWrapper();
		StatusDescription statusDescription = new StatusDescription();
		try {
			response.setStatusDescription(statusDescription);
			//save users-unique-identifiaction-details
			saveUserUniqueIdentificationDetails(requestWrapper);
			
			statusDescription.setStatusCode(ConstantManager.Success.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.Success.getStatusMessage());

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription.setStatusCode(ConstantManager.InternalServerError.getStatusCode());
			statusDescription.setStatusMessage(ConstantManager.InternalServerError.getStatusMessage());
		}
		return response;
	}

	private UsersUniqueIIdentification saveUserUniqueIdentificationDetails(
			UsersUniqueIdentificationrequestWrapper requestWrapper) {
		UsersUniqueIIdentification ui = new UsersUniqueIIdentification();
		try {
			ui.setAadharCardNo(requestWrapper.getAadharCardNo());
			ui.setDateTime(new Date());
			ui.setUserId(requestWrapper.getUserId());
			ui = usersUniqueIdentificationRepo.save(ui);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ui;
	}

}
