package com.akp.configuration.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService  {

	public User loadUserByUsername(String username) {
		
		String password="";
		
		String role="";
		
		//Collection<? extends GrantedAuthority> authorities = null;
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
	      SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
	      authorities.add(simpleGrantedAuthority);
		User user = new User(username, password, true, true, true, true, authorities);
		return user;
	}

}
