package com.adminclient.SpringBootAdminClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootAdminClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminClientApplication.class, args);
	}

}