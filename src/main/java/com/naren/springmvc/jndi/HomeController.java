package com.naren.springmvc.jndi;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private Logger log = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/db")
	public String showHome(){
		log.debug("Welcome to home page.....");
		return "home";
	}
	
}
