package com.userscontact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAutoConfiguration
@EnableAdminServer
@Configuration
@SpringBootApplication
public class UsersContactMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersContactMicroserviceApplication.class, args);
	}

}
