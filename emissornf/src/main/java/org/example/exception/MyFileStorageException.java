package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileStorageException extends AuthenticationException {

	
	private static final long serialVersionUID = 1L;

	public MyFileStorageException(String exception) {
		super(exception);
	}
	public MyFileStorageException(String exception, Throwable cause) {
		super(exception, cause);
	}
	
}
