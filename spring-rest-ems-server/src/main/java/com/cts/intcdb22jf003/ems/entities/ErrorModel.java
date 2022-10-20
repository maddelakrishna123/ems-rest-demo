package com.cts.intcdb22jf003.ems.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

}
