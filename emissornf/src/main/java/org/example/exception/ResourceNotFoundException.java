package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceNotFoundException extends AuthenticationException {

	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}
	public ResourceNotFoundException(String exception, Throwable cause) {
		super(exception);
	}
}
