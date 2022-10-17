package com.cts.intcdb22jf003.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.intcdb22jf003.ems.entities.Employee;
import com.cts.intcdb22jf003.ems.services.EmployeeServices;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.pool.TypePool.Default.ReaderMode;

@RestController
@Slf4j
public class EmployeeController {
	@Autowired
  private EmployeeServices service;
	@PostMapping("/employee")
	
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Employee> create( @RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(service.createNewEmployee(emp), HttpStatus.CREATED);
	}
	@GetMapping("/employee")
	
	public List<Employee> getEmps()
	{
		return service.getAllEmployees();
	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> update( @RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(service.updateEmployee(emp), HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id)
	{
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam("id") int id)
	{service.deleteEmployee(id);
		
		
		return "Employee Deleted";
	}
	
}
