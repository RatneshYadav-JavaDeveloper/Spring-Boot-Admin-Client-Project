package com.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entities.Users;

public interface UsersRepo  extends JpaRepository<Users, Long>{

	Users findByMobileNoAndStatus(String mobileNo , String status);
}
