package com.app.versequill.service.impl;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.versequill.dto.RegistrationDTO;
import com.app.versequill.entity.Registration;
import com.app.versequill.repository.RegistrationRepository;
import com.app.versequill.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationRepository regRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    
    @Override
    public Registration saveUser(RegistrationDTO register) {
    	try {
    		register.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
    		
    		Registration user= new Registration();
        	user.setEmail(register.getEmail());
        	user.setUser_name(register.getUser_name());
        	user.setPassword(register.getPassword());
            return regRepo.save(user);
            
		} catch (Exception e) {
			LOGGER.error("Exception while saving the user: "+e);
			throw new RuntimeException("User registration failed", e);
		}
    	
    }
     
    @Override
    public Boolean checkUserExsist(String username) {
    	if(regRepo.existsByUserName(username))
    		return true;
    	else
    		return false;
    }
    
}
