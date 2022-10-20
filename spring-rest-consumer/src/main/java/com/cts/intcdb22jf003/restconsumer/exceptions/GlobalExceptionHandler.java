package com.cts.intcdb22jf003.restconsumer.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(HttpClientErrorException.class)
	public String hanldeHttpClientErrorException(HttpClientErrorException ex, Model model)
	{
		model.addAttribute("message", "Your are not registed<a href='register'>register</a>");
		
		return "error";
	}

}
