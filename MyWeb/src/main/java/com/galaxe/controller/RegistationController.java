package com.galaxe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.galaxe.model.RegistrationDetails;
@Controller
public class RegistationController {
	
	@Autowired
	private EmployeeService service;
	@RequestMapping(value="registrationdisplay" , method=RequestMethod.GET)
	public ModelAndView doDisplayRegistration(@ModelAttribute("registrationDetails") RegistrationDetails registrtionDetails)
	{
		ModelAndView modelAndView= new ModelAndView("registration");
		//modelAndView.addObject("registrationDetails",new RegistrationDetails());
		return modelAndView;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView doRegisterUser(@Valid @ModelAttribute("registrationDetails") RegistrationDetails registrationDetails,BindingResult result)
	{
		ModelAndView modelAndView;
		if(result.hasErrors()){
			modelAndView=new ModelAndView("registration");
			return modelAndView;
		}
		else{
		if(service.save(registrationDetails)){
			modelAndView=new ModelAndView("registrationsuccess");
			return modelAndView;
		}
		else{
			modelAndView=new ModelAndView("registrationfail");
			return modelAndView;
		}
		}
	}

}
