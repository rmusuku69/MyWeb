package com.galaxe.controller;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.galaxe.model.LoginDetails;
import com.galaxe.model.RegistrationDetails;
import com.galaxe.model.Search;

@Controller
public class LoginController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value="logindisplay", method=RequestMethod.GET)
	public ModelAndView doDisplayLogin()
	{
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("loginDetails") LoginDetails loginDetails,@ModelAttribute("search") Search search) throws SQLException
	{
		ModelAndView modelAndView=null;
		ArrayList<Object> list=new ArrayList<Object>();
		if(service.authenticate(loginDetails.getUsername(), loginDetails.getPassword()) != null)
		{
			List<String> fields=new ArrayList<String>();
			list=service.authenticate(loginDetails.getUsername(), loginDetails.getPassword());
			RegistrationDetails registrationDetails=(RegistrationDetails) list.get(0);
			Field[] fieldsList=registrationDetails.getClass().getDeclaredFields();
			for(int i=0;i<fieldsList.length;i++)
			{
				fields.add(fieldsList[i].getName());
			}
			fields.remove("password");
			list.remove(0);
			list.add(0,registrationDetails.getName());
			list.add(1,registrationDetails.getEmail());
			list.add(2, registrationDetails.getContact());
			modelAndView=new ModelAndView("loginsuccess");
			modelAndView.addObject("arraylist", list);
			modelAndView.addObject("fields",fields);
	       	return modelAndView;
		}
		else
		{
			modelAndView=new ModelAndView("login");
			modelAndView.addObject("msg", "** Username or Password Incorrect");
	       	return modelAndView;
		}
	}
	
	@RequestMapping(value="viewall",method=RequestMethod.GET)
	public ModelAndView viewAll()
	{
		List<Object> list=service.viewAllUsers();
		ModelAndView modelAndView=new ModelAndView("viewall");
		modelAndView.addObject("list",list);
		modelAndView.addObject("msg", "Total Users : "+list.size());
		return modelAndView;
	}
	@RequestMapping(value="search",method=RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("search") Search search)
	{
		ModelAndView modelAndView=new ModelAndView("searchresult");
		List<Object> result=service.getDetailsByParam(search.getSearchParam(), search.getSearchCriteria());
		if(result!=null){
		String msg="** "+result.size()+" Results found";
		modelAndView.addObject("msg",msg);
		if(!(result.isEmpty()))
		modelAndView.addObject("searchResult", result);}
		return modelAndView;
	}
	
	@RequestMapping(value="showEditUserDetails",method=RequestMethod.GET)
	public ModelAndView showEdituserDetails(@RequestParam("id") int id)
	{
		ModelAndView modelAndView=new ModelAndView("edituserdetails");
		List<Object> result=service.getDetailsByParam(new Integer(id).toString(),"id");
		if(result!=null){
		String msg="** "+result.size()+" Results found";
		modelAndView.addObject("msg",msg);
		if(!(result.isEmpty()))
		modelAndView.addObject("details", result.get(0));}
		return modelAndView;
	}
	@RequestMapping(value="updateUserDetails",method=RequestMethod.POST)
	public ModelAndView updateUserDetails(@Valid @ModelAttribute("details") RegistrationDetails registrationDetails,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()){
			System.out.println("error in page");
			return new ModelAndView("edituserdetails");
		}
		else{
			service.update(registrationDetails);
			return viewAll();
		}
	}
	
	@RequestMapping(value="deleteUser",method=RequestMethod.GET)
	public ModelAndView deleteuserDetails(@RequestParam("id") int id)
	{
		service.deleteUserById(id);
		return viewAll();
	}
}
