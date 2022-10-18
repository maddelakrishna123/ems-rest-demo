package com.cts.intcdb22jf003.ems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.intcdb22jf003.ems.entities.Employee;
import com.cts.intcdb22jf003.ems.repositories.EmployeeRepository;

@SpringBootApplication
public class SpringRestEmsServerApplication {
@Autowired
	private EmployeeRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(SpringRestEmsServerApplication.class, args);
	}
	
	
	
	//@PostConstruct
	
	public void initData()
	{
		
	List<Employee> empList =	Stream.of(
				
				
				new Employee(101,"krishna",20000,35,"krishna123","1234","krishna@gmail.com","8500493754"),
				new Employee(102,"Nithin Gupta",40000,25,"nithin123","1234","nithin@gmail.com","8500493754"),
				new Employee(103,"rahul vats",30000,27,"rahul123","1234","rahul@gmail.com","8500493754")
				
				).collect(Collectors.toList());
	
	
	repo.saveAll(empList);
		
	}

}
