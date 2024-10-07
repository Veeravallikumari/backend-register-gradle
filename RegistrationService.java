package com.cts.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cts.Registration.model.Caregiver;
import com.cts.Registration.model.User;
import com.cts.Registration.repository.CaregiverRepository;
import com.cts.Registration.repository.RegistrationRepository;


@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	@Autowired
	private CaregiverRepository carerepo;
	
	
	
	
	public User saveUser(User user){
		return repo.save(user);	
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.getReferenceById(id);
	}

	public Caregiver assignCareGiver(int userId, int careId) {
		// TODO Auto-generated method stub
		User user =this.getUserById(userId);

		Caregiver caregiver=carerepo.findById(careId).get();
		
		if(user.getCaregiver().size()==2) {
			throw new RuntimeException("limit exceeded");
		}
		
		user.getCaregiver().add(caregiver); 
		caregiver.setStatus("Assigned");
			repo.save(user);
			return caregiver;
			
	}

	


	
	
}
