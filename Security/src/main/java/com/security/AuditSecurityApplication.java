package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AuditSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSecurityApplication.class, args);

	}

}
