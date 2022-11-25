package com.security.model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ErrorResponse {
	
	private String timestamp;
	private HttpStatus httpStatus;
	private String message;
	
}
