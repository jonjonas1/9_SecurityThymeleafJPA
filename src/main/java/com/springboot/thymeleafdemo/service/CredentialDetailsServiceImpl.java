package com.springboot.thymeleafdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springboot.thymeleafdemo.dao.CredentialRepository;
import com.springboot.thymeleafdemo.entity.Credential;

public class CredentialDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CredentialRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyCredentialDetails(user);
	}

}
