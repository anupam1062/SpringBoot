package com.akp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akp.configuration.authentication.TokenAuthenticationService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	 public String authorize(@RequestParam String username, @RequestParam String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        //Use authenticationManager injected in Controller.
       // Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(token);
        //USE UserDetailService injected 
        // Use THIS UserDetails details = this.userDetailsService.loadUserByUsername(username);
        UserDetails details = new org.springframework.security.core.userdetails.User(username,password, new ArrayList<>());
        return tokenAuthenticationService.getAuthenticationToken(details);
    }
}
