/**
 * 
 */
package com.userscontact.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userscontact.entities.UsersContact;

/**
 * @author Ratnesh
 *
 */
public interface UsersContactRepo extends JpaRepository<UsersContact, Long> {

	UsersContact findTop1ByUserId(Long userId);
}