package com.cts.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.Registration.model.Caregiver;
import com.cts.Registration.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
	
	public User findByEmailId(String emailid);
	public User findByEmailIdAndPassword(String emailid, String password);
}
