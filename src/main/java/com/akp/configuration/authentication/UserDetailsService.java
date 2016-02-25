package com.akp.configuration.authentication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService  {

	
	@Autowired
	private DataSource dataSource;
	
	public User loadUserByUsername(String username) {
		
		String password="";
		
		String role="";
		
	try{
		Connection con =dataSource.getConnection();
		Statement stmt =con.createStatement();
		String sql = "SELECT user.user_pk, user.user_id, role.role_name,user.appl_password "
		          + "FROM ref_user as user LEFT JOIN ref_user_role_pcpt  as pcpt  "
		          + "ON user.user_pk = pcpt.user_pk "
		          + "LEFT JOIN ref_role as role On pcpt.role_pk = role.role_pk " + "WHERE user.user_id  = '"
		          + username + "'";
		   ResultSet  rs = stmt.executeQuery(sql);
		   username=rs.getString("username");
		   }catch(Exception e){
			   e.printStackTrace();}
	
		
		//Collection<? extends GrantedAuthority> authorities = null;
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
	      SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
	      authorities.add(simpleGrantedAuthority);
		User user = new User(username, password, true, true, true, true, authorities);
		return user;
	}

}
