package com.app.versequill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.versequill.dto.RegistrationDTO;
import com.app.versequill.service.impl.RegistrationServiceImpl;

@CrossOrigin("*")
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationServiceImpl registerService;
   
    @PostMapping("/registerUser")
    public ResponseEntity<?>  saveUser(@RequestBody RegistrationDTO register){
    	try {
    		if(registerService.checkUserExsist(register.getUser_name()))
    			return new ResponseEntity<>("User allredy exsist",HttpStatus.CONFLICT);
    		
    		System.out.println("Received Data: "+ register.getEmail());
        	return new ResponseEntity<>(registerService.saveUser(register), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Exception while save the user: "+e.getStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
