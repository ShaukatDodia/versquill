package com.app.versequill.service;

import com.app.versequill.dto.RegistrationDTO;
import com.app.versequill.entity.Registration;

public interface RegistrationService {
     public Registration saveUser(RegistrationDTO register);
     public Boolean checkUserExsist(String user_name);
}
