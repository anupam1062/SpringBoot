package com.akp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.akp.configuration.authentication.CustomAuthentication;
import com.akp.model.UserDetails;

@RestController
@SessionAttributes("credentials")
public class LoginController {
	
	@Autowired
	private CustomAuthentication authentication;
	
	
	@RequestMapping("/")
    public ModelAndView home() {
 ModelAndView mav =new ModelAndView();
 
 mav.setViewName("Home");
 return mav;
 }


@RequestMapping("/login")

public ModelAndView login(){
	ModelAndView mav=new ModelAndView();
	UserDetails userDetails=new UserDetails();
	mav.addObject("credentials", userDetails);
	mav.setViewName("Ologin");
	return mav;
}

@RequestMapping(value="/welcome", method=RequestMethod.POST)
public ModelAndView welcome(@ModelAttribute("credentials") final UserDetails userDetails){
	ModelAndView mav=new ModelAndView();
	//CustomAuthentication authentication=new CustomAuthentication();
	String username= userDetails.getUsername();
	String password = userDetails.getPassword();
	try{
		authentication.authenticate(username ,password);
	}catch(Exception e){ 
		 mav.setViewName("Login_error");
		 return mav;
	}
	mav.addObject("credentials", userDetails);
	mav.setViewName("Welcome");
	return mav;
	
}
}

	


