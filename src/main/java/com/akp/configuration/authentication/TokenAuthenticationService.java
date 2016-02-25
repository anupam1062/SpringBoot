package com.akp.configuration.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenAuthenticationService {

	private static final String AUTH_HEADER_NAME = "Authorization";
    @Autowired
    @Qualifier(value="TokenHandler")
    private TokenHandler tokenHandler;

    public TokenAuthenticationService() {
    
    }

    public String getAuthenticationToken(final UserDetails user) {
        return tokenHandler.createTokenForUser(user);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            final UserDetails userDetails = tokenHandler.parseUserFromToken(token);
            if (userDetails != null) {
                return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
            }
        }
        return null;
    }
	
}
