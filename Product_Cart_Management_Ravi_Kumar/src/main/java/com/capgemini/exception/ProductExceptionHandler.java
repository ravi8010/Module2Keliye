package com.capgemini.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //allowing you to write global code 
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=DuplicateIdExistException.class)
	public final ResponseEntity<Object> handleAllException(DuplicateIdExistException ex,WebRequest request)
	{			return (new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND));	

	}
	@ExceptionHandler(value=IDDoesNotExistException.class)
	public final ResponseEntity<Object> handleAllException(IDDoesNotExistException ex,WebRequest request)
	{	
		return (new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND));	
	
	}
	@ExceptionHandler(value=ProductEmptyException.class)
	public final ResponseEntity<Object> handleAllException( ProductEmptyException ex,WebRequest request)
	{	
		return (new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND));	
	
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<>(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR); //overide handleMethodArgumentNotValid from source
	}

	
}
