package com.sai.WholesaleTransport.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sai.WholesaleTransport.pojo.Login;

@Component("userDetailsDao")
public class UserDetailsDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public Login getUserByUsername(String username) {
		List<Login> logins = (List<Login>) hibernateTemplate.find("FROM Login  WHERE username = ? ", username);
		if(logins != null && !logins.isEmpty() && logins.size() == 1  ) {
			if(logins.get(0).getPerson() != null &&  logins.get(0).getPerson().getStatus() ==null){
				throw new RuntimeException("User Inactive");
			}
			return logins.get(0);
		} else {
			 throw new RuntimeException("Enter Correct username");
		}
	}
}
