package com.teacher.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleEmailNullException(BadRequestException ex) {
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(new Date().toString());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailExistException.class)
	public ResponseEntity<ErrorResponse> handleEmailExistException(EmailExistException ex) {
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(new Date().toString());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotException(NotFoundException ex) {
		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(new Date().toString());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
