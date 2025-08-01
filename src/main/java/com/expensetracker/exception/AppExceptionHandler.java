package com.expensetracker.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler
	public String handleUserNotFoundException(UserNotFound exception) {
		return exception.getMessage();
	}

}
