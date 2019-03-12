package com.capgemini.exception;

@SuppressWarnings("serial")
public class ProductEmptyException extends RuntimeException {

	public ProductEmptyException(String message) {
		super(message);
		
	}

}
