package com.akp.configuration.authentication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthentication {
	@Autowired
	private DataSource dataSource;
	
	String username=null;
	String password=null;
	String role=null;
	
	public void authenticate(String Username ,String Password) throws Exception{
		try{
			Connection con=dataSource.getConnection();
			Statement stmt =con.createStatement();
			String sql = "SELECT user.user_pk, user.username,role.role,user.password "
			          + "FROM user as user LEFT JOIN user_role_pcpt  as pcpt  "
			          + "ON user.user_pk = pcpt.user_pk "
			          + "LEFT JOIN role as role On pcpt.role_pk = role.role_pk " + "WHERE user.username  = '"
			          + Username + "'";
			   ResultSet  rs = stmt.executeQuery(sql);
			   username=rs.getString("username");
			   password =rs.getString("passowrd");
			    if (username.equals(Username)&&password.equals(Password)){
			    	
			    }else{
			    	throw new UsernameNotFoundException("Username not found or is not authenticated");
			    }
			   
		}catch(UsernameNotFoundException e){
			e.getMessage();
		}catch(Exception e){
			throw new Exception();
		}
		
	}

}
