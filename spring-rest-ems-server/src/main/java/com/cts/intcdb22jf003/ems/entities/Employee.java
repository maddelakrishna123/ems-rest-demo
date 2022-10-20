package com.cts.intcdb22jf003.ems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Employee {
    @Id
  @GeneratedValue
	private int id;
	private String name;
	private double salary;
	@Min(value = 25, message = "Invalid AGE")
	private int age;
	@Column(unique = true)
	
	@Pattern(regexp = "^[a-zA-Z0-9]{7,15}$",message = "Invalid username")
	private String username;
	private String password;
	@Column(unique = true)
	private String email;
	private String mobile;
	
	// getters and Setters
	
	// constructors
	
	// To String 
	
	// equals and HashCode
}
