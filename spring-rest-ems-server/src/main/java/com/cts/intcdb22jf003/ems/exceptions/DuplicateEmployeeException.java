package com.cts.intcdb22jf003.ems.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateEmployeeException extends RuntimeException {

	public DuplicateEmployeeException(String message) {
		super(message);
		
	}
	
	

}
