package com.cts.intcdb22jf003.restconsumer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.intcdb22jf003.restconsumer.model.Employee;
import com.cts.intcdb22jf003.restconsumer.services.EmployeeConsumerServices;

@Controller
@SessionAttributes(names = {"username"})
public class EmployeeeConsumerController {
	@Autowired
	private EmployeeConsumerServices services;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username , @RequestParam("password") String password,Model model)
	{
		
		//System.out.println(username +" "+password);
		
		if(services.isValidLogin(username, password))
		{
			
			model.addAttribute("username", username);
			return "emphome";
		}
		else
		{
			model.addAttribute("errMsg", "Invalid Username or password");
		return "login";
		
		}
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register()
	{
		return "register";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register( @ModelAttribute Employee employee, Model model)
	{
		
		if( services.createNewEmployee(employee))
		{
			model.addAttribute("message", "Employee Created Successfully");
		}
		
		return "register";
	}
	
	@GetMapping("/profile")
	public String profile(Model model,HttpSession session)
	{
		String username = (String)session.getAttribute("username");
		System.out.println("Session value "+username);
		model.addAttribute("emp", services.getEmployee(username));
		return "profile";
	}
	@GetMapping("/userhome")
	public String back()
	{
		return "emphome";
	}
	
}
