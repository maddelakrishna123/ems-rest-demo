package com.cts.intcdb22jf003.restconsumer.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
	private int id;
	private String name;
	private double salary;
	private int age;
	private String username;
	private String password;
	private String email;
	private String mobile;
	
}
