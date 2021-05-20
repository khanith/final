package com.ltts.shadow.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ltts.shadow.Repositories.UserJPA;
import com.ltts.shadow.model.UsersLog;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserJPA ujpa;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			UsersLog u=ujpa.findByUsername(username);

		if (u.getUsername().equals(username)) {
			return new User(u.getUsername(), u.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}