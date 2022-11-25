package com.student.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String message;
	private HttpStatus status;
	private String timestamp;

}
