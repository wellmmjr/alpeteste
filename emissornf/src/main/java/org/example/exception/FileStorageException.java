package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileStorageException extends AuthenticationException {

	
	private static final long serialVersionUID = 1L;

	public FileStorageException(String exception) {
		super(exception);
	}
	public FileStorageException(String exception, Throwable cause) {
		super(exception, cause);
	}
}
