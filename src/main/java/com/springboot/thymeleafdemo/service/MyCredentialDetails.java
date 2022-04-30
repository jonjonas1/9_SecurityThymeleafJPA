package com.springboot.thymeleafdemo.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.thymeleafdemo.entity.Credential;

public class MyCredentialDetails implements UserDetails {
	
	private Credential cred;
	

	public MyCredentialDetails(Credential cred) {
		this.cred = cred;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(cred.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return cred.getPassword();
	}

	@Override
	public String getUsername() {
		return cred.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
