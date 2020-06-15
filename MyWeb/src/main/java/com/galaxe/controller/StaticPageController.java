package com.galaxe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaticPageController {
	
	
	
	@RequestMapping(value="careers", method=RequestMethod.GET)
	public String careers()
	{
		return "careers";
	}
	
	@RequestMapping(value="aboutus", method=RequestMethod.GET)
	public String aboutus()
	{
		return "aboutus";
	}

}
