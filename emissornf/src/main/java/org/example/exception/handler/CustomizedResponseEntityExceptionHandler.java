package org.example.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.example.exception.ExceptionResponse;
import org.example.exception.InvalidJWTAuthenticationException;
import org.example.exception.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionRresponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionRresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionRresponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionRresponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidJWTAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> invalidJWTAuthenticationException(Exception ex, WebRequest request){
		ExceptionResponse exceptionRresponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionRresponse, HttpStatus.BAD_REQUEST);
	}
}
