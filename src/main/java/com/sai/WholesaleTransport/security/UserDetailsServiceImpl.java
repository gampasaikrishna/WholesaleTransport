package com.sai.WholesaleTransport.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sai.WholesaleTransport.pojo.Login;



@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = userDetailsDao.getUserByUsername(username);
		if(login == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return login;
	}
}
