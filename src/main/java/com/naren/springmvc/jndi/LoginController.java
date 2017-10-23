package com.naren.springmvc.jndi;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naren.springmvc.dao.User;
import com.naren.springmvc.servicelayer.UsersService;

@Controller
public class LoginController {
	
	private UsersService service;
	
	@Autowired
	public void setService(UsersService service) {
		this.service = service;
	}

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
	
	@RequestMapping("/register")
	public String showRegister(Model model){
		
		model.addAttribute("user",new User());
		
		return "register";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){
		
		List<User> users = service.getAllUsers();
		model.addAttribute("user", users);
		
		return "admin";
	}
	
	@RequestMapping(value="/created", method=RequestMethod.POST)
	public String newAccount(@Valid User user, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("Form Invalid");
			return "register";
		}
		
		user.setEnable(true);
		user.setAuthorization("user");
		
		if(service.exists(user.getUsername())){
			System.out.println("Duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username");
			return "register";
		}
		
		try{
		service.create(user);
		}catch(DuplicateKeyException e){
			result.rejectValue("username", "DuplicateKey.user.username");
			return "register";
		}
		return "accountcreated";
	}

}
