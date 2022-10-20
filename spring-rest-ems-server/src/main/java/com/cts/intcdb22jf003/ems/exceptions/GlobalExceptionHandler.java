package com.cts.intcdb22jf003.ems.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.intcdb22jf003.ems.entities.ErrorModel;

//ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorModel handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest req)
	{
		
		ErrorModel error = new ErrorModel(new Date(), 403, "NOT FOUND", ex.getMessage(), req.getDescription(false));
		
		
		return  error;
	}
	

	
	@ExceptionHandler(DuplicateEmployeeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorModel handleDuplicateEmployeeException(DuplicateEmployeeException ex, WebRequest req)
	{
		
		
		ErrorModel error = new ErrorModel(new Date(), 400, "BAD REQUEST", ex.getMessage(), req.getDescription(false));
		
		
		return  error;
	}
	
	
	
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	
	
	
	Map<String, String> errorMap = new HashMap<String, String>();
	ex.getBindingResult().getFieldErrors().stream().forEach(t-> errorMap.put(t.getField(), t.getDefaultMessage()));
	
	return new ResponseEntity<Object>(errorMap,status);
}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorModel handleGlobalException(Exception ex, WebRequest req)
	{
		
		ErrorModel error = new ErrorModel(new Date(), 500 ,"Internal Server Error", ex.getMessage(), req.getDescription(false));
		
		
		return  error;
	}
}
