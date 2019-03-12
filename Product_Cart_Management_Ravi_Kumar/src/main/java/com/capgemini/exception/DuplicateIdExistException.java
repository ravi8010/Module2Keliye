package com.capgemini.exception;

@SuppressWarnings("serial")
public class DuplicateIdExistException extends RuntimeException {

	public DuplicateIdExistException(String message) {
		super(message);
		
	}

}
