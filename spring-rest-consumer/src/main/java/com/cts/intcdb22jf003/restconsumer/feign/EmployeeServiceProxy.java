package com.cts.intcdb22jf003.restconsumer.feign;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.intcdb22jf003.restconsumer.model.Employee;



@FeignClient(name="employee-service",url =  "http://localhost:8081/ems/api")
public interface EmployeeServiceProxy {

	@PostMapping("/hello")
	public String hello(@RequestBody String name);	
	
    @PostMapping("/employee")
    public ResponseEntity<Employee> create(@RequestBody Employee emp);
    @GetMapping("/employeebyusername/{username}")
	public Employee getEmployeeByUserName(@PathVariable("username") String  username);
    
    @PutMapping("/employee")
	public ResponseEntity<Employee> update( @RequestBody Employee emp);
    
    @DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam("id") int id);
     @GetMapping("/employee")
	
	public List<Employee> getEmps();
}
