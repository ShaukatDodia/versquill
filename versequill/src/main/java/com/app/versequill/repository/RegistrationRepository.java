package com.app.versequill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.versequill.dto.RegistrationDTO;
import com.app.versequill.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

	boolean existsByUserName(String user_name);
	RegistrationDTO findByUserName(String user_name);
}
