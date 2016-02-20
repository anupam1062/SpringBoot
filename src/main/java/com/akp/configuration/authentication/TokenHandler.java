package com.akp.configuration.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Created by jhipster on 10/25/15.
 */
@Component(value="TokenHandler")
public class TokenHandler {

    private final String secret;
    
    @Autowired
    private  UserDetailsService userDetailsService;

    
    public TokenHandler() {
    	//get this from some external config
        this.secret = "abchello123";
    }

    public UserDetails parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userDetailsService.loadUserByUsername(username);
    }

    public String createTokenForUser(UserDetails user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

}