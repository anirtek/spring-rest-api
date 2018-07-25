package io.anirtek.api.exception;

public class BadRequstException extends RuntimeException {
	public BadRequstException(String message) {
		super(message);
	}
	
	public BadRequstException(String message, Throwable cause) {
		super(message, cause);
	}
}
