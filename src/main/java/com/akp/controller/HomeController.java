package com.akp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akp.configuration.authentication.TokenAuthenticationService;
import com.akp.configuration.authentication.UserDetailsService;

@RequestMapping("/home")
@RestController
public class HomeController {

	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<String> authorize(@RequestBody com.akp.model.UserDetails credentials) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(),
				credentials.getPassword());
System.out.println("inside home controller");
		try {
			Authentication authentication = this.authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (UsernameNotFoundException e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("authentication.bad.request", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(credentials.getUsername());
		String jwt = tokenAuthenticationService.getAuthenticationToken(userDetails);
		return new ResponseEntity<String>(jwt, HttpStatus.OK);
	}
}
