package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidJWTAuthenticationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public InvalidJWTAuthenticationException(String exception) {
		super(exception);
	}
}
