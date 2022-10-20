package com.cts.intcdb22jf003.ems;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cts.intcdb22jf003.ems.controllers.EmployeeController;
import com.cts.intcdb22jf003.ems.entities.Employee;
import com.cts.intcdb22jf003.ems.repositories.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

//@WebMvcTest
//@AutoConfigureMockMvc
public class EmployeeControllerTest {
	 @Autowired
	    private MockMvc mockMvc;
	 @Autowired
	 private EmployeeRepository employeeRepository;
	 @Autowired
	 private EmployeeController employeeController;
	 
	 
	 @Test
	 public void testCreateEployee() throws Exception {
		 
		
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Employee emp = new Employee();
		emp.setId(1012);
		emp.setName("Rajesh");
		emp.setAge(27);
		emp.setSalary(20000);
		emp.setEmail("rajesh@gmail.com");
		emp.setUsername("rajesh123");
		emp.setPassword("12345");
		emp.setMobile("8500493754");
	String str=	objectWriter.writeValueAsString(emp);
		 
		mockMvc.perform(MockMvcRequestBuilders.post("/ems/employee").content(str)).andExpect(MockMvcResultMatchers.status().isCreated());
	 }
}
