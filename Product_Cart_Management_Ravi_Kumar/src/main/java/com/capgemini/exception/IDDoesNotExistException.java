package com.capgemini.exception;

@SuppressWarnings("serial")
public class IDDoesNotExistException extends RuntimeException {

	public IDDoesNotExistException(String message) {
		super(message);
		
	}

}
