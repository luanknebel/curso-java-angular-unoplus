package com.unochapeco.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.unochapeco.example.dto.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ExceptionDTO> handleThrowable(Throwable throwable) {
		
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		if(throwable instanceof BadCredentialsException) {
			httpStatus = HttpStatus.FORBIDDEN;
		}
		if(throwable instanceof BusinessException) {
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		
		ExceptionDTO exceptionDTO = new ExceptionDTO(throwable.getMessage());
		return new ResponseEntity<ExceptionDTO>(exceptionDTO, httpStatus);
	}

}
