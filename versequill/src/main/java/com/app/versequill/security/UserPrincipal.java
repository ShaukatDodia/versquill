package com.app.versequill.security;


import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.versequill.dto.RegistrationDTO;
import com.app.versequill.entity.Registration;

public class UserPrincipal implements UserDetails{
	
	private RegistrationDTO register;
	
	
	
	public UserPrincipal(RegistrationDTO registration) {
		this.register = registration;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return register.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return register.getUser_name();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return UserDetails.super.isAccountNonExpired();
	}
}
