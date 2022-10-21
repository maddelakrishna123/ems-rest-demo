package com.cts.intcdb22jf003.restconsumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("user1", "4c63500a-9659-41bf-afa3-ea67a59bdcea");
		
		// localhost:8081/ems/api/employee/krishna123
		
		
		//RestTemplate template = new RestTemplate();
		
		HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
		
		ResponseEntity<Employee> resp =	template.exchange("http://localhost:8081/ems/api/employeebyusername/\"+username", HttpMethod.GET, entity,Employee.class);
	//ResponseEntity<Employee> resp=	template.getForEntity("http://localhost:8081/ems/api/employeebyusername/"+username, Employee.class);
			
	Employee employee =resp.getBody();
			// Employee employee =proxy.getEmployeeByUserName(username);
			 
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
	

	
	public Employee updateEmployee(Employee employee)
	{
		return proxy.update(employee).getBody();
	}
	
	public Employee getEmployee(String username)
	{
		return proxy.getEmployeeByUserName(username);
	}
}
