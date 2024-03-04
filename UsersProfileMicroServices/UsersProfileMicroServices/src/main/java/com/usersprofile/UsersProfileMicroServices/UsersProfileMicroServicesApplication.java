package com.usersprofile.UsersProfileMicroServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAdminServer
@EnableAutoConfiguration
@SpringBootApplication
public class UsersProfileMicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersProfileMicroServicesApplication.class, args);
	}

}
