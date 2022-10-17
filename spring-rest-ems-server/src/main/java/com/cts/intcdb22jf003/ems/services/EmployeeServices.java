package com.cts.intcdb22jf003.ems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.intcdb22jf003.ems.entities.Employee;
import com.cts.intcdb22jf003.ems.exceptions.DuplicateEmployeeException;
import com.cts.intcdb22jf003.ems.exceptions.EmployeeNotFoundException;
import com.cts.intcdb22jf003.ems.repositories.EmployeeRepository;
@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRepository empRepo;
	// creating employee
	
	public Employee createNewEmployee(Employee employee)
	{
		
	Optional<Employee>	 empOpt = empRepo.findById(employee.getId());
		
	if(empOpt.isPresent())
	{
		throw new DuplicateEmployeeException("Employee Already Found");
	}
	else
	{
	return empRepo.save(employee);	
	}
		
		
	}
	
	// for getEmployee BY ID ,
	
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee>	 empOpt = empRepo.findById(id);
		
		if(empOpt.isPresent())
		{
			return empOpt.get();
		}
		else
		{
		throw new EmployeeNotFoundException("Employee Not Found");
		}
				
	}
	// By User Name
	
	public Employee getEmployeeByUserName(String username)
	{
Optional<Employee>	 empOpt = empRepo.findByUsername(username);
		
		if(empOpt.isPresent())
		{
			return empOpt.get();
		}
		else
		{
		throw new EmployeeNotFoundException("Employee Not Found");
		}
				
	}
	
	// GetALL 
	
	public List<Employee> getAllEmployees()
	{
		return empRepo.findAll();
	}
	
	
	
	
	public Employee updateEmployee(Employee employee)
	{
		Optional<Employee>	 empOpt = empRepo.findById(employee.getId());
		
		if(empOpt.isPresent())
		{
			return empRepo.save(employee);	
		}
		else
		{
			throw new EmployeeNotFoundException("Employee notb Found");
		
		}	
	}
	

	
	public void deleteEmployee(int id)
	{
Optional<Employee>	 empOpt = empRepo.findById(id);
		
		if(empOpt.isPresent())
		{
			Employee e = empOpt.get();
			
			empRepo.delete(e);
		}
		else
		{
		throw new EmployeeNotFoundException("Employee Not Found");
		}
	}
	
}
