package com.unochapeco.example.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BusinessException(Throwable cause) {
        super(cause);
    }
	
}
