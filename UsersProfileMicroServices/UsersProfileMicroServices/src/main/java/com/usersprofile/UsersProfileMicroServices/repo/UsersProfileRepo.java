/**
 * 
 */
package com.usersprofile.UsersProfileMicroServices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usersprofile.UsersProfileMicroServices.entities.UsersProfile;

/**
 * @author Ratnesh
 *
 */
public interface UsersProfileRepo extends JpaRepository<UsersProfile, Long> {

}
