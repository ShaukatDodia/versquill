package com.app.versequill.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.versequill.dto.RegistrationDTO;
import com.app.versequill.repository.RegistrationRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class MyUserService implements UserDetailsService{
	
	@Autowired
	private RegistrationRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		RegistrationDTO registration= userRepo.findByUserName(username);
		
		if(registration==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new UserPrincipal(registration);
	}

}
