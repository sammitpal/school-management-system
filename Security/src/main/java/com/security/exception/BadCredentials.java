package com.security.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadCredentials extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadCredentials(String message) {
		super(message);
		log.info(message);

	}

}
