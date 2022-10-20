package com.cts.intcdb22jf003.restconsumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cts.intcdb22jf003.restconsumer.feign.EmployeeServiceProxy;
import com.cts.intcdb22jf003.restconsumer.model.Employee;

@Service
public class EmployeeConsumerServices {
	@Autowired
   private RestTemplate template;
	@Autowired
private EmployeeServiceProxy proxy;
	private static final String BASE_URL="http://localhost:8081/ems/api/";
	
	public boolean isValidLogin(String username, String password)
	{
		
		
		// localhost:8081/ems/api/employee/krishna123
		
		
			//RestTemplate template = new RestTemplate();
			//ResponseEntity<Employee> resp=	template.getForEntity("http://localhost:8081/ems/api/employeebyusername/"+username, Employee.class);
			
		
			 Employee employee =proxy.getEmployeeByUserName(username);
			 
			  if(employee.getPassword().equals(password))
			  {
				  return true;
			  }
			  
			 
		
		return false;
			  
	}
	
	
	
	
	
	public boolean createNewEmployee(Employee employee)
	{
		//RestTemplate template = new RestTemplate();
	//	ResponseEntity<Employee> empResp=		 template.postForEntity(BASE_URL+"/employee", employee, Employee.class);
		
		
		ResponseEntity<Employee> empResp = proxy.create(employee);
if(empResp.getStatusCode().value() == 201)
	return true;
		
		return  false;
	}
	

	
	public Employee getEmployee(String username)
	{
		return proxy.getEmployeeByUserName(username);
	}
}
