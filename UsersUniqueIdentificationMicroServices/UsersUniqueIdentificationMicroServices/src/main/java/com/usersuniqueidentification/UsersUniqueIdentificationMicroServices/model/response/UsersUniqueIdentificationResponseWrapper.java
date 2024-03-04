/**
 * 
 */
package com.usersuniqueidentification.UsersUniqueIdentificationMicroServices.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * @author Ratnesh
 *
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class UsersUniqueIdentificationResponseWrapper {

	private StatusDescription statusDescription;

	public StatusDescription getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(StatusDescription statusDescription) {
		this.statusDescription = statusDescription;
	}

}
