package com.akp.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	
	@RequestMapping("/")
    String home() {
       return  "Hello Welcome to Spring Boot";
    }


		
	}


