package com.capg.rest.exception;

public class ReviewNotFoundException extends RuntimeException
{
	private String message;
	public ReviewNotFoundException() {
		
	}
	public ReviewNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public String toString() {
		return "ReviewNotFoundException"+message;
	}
}
