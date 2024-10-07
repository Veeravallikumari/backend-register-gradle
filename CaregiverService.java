package com.cts.Registration.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Registration.model.Caregiver;

import com.cts.Registration.repository.CaregiverRepository;



@Transactional
@Service
public class CaregiverService {
	
	@Autowired
	private CaregiverRepository carerepo;
	


	public Caregiver saveCaregiver(Caregiver caregiver) {
		return carerepo.save(caregiver);
	}
	public List<Caregiver> fetchCaregiverList() {
		// TODO Auto-generated method stub
		return carerepo.findAll();
	}
	

	
	public Caregiver fetchCaregiverById(int id) {
		return carerepo.findById(id).get();
	}
	public void deleteCaregiverById(int id) {
		carerepo.deleteById(id);
	}
	
	public Caregiver updateCaregiver(int id, Caregiver caregiver) {
	
		Caregiver cgDB=carerepo.findById(id).get();
		
		if(!caregiver.getFirstName().isEmpty() && !" ".equalsIgnoreCase(caregiver.getFirstName())){
			cgDB.setFirstName(caregiver.getFirstName());
		}
		
		if(!caregiver.getLastName().isEmpty() && !" ".equalsIgnoreCase(caregiver.getLastName())){
			cgDB.setLastName(caregiver.getLastName());
		}
		
		if(!caregiver.getEmailId().isEmpty() && !" ".equalsIgnoreCase(caregiver.getEmailId())){
			cgDB.setEmailId(caregiver.getEmailId());
		}
		
		if(!caregiver.getAddress().isEmpty() && !" ".equalsIgnoreCase(caregiver.getAddress())){
			cgDB.setAddress(caregiver.getAddress());
			
		}
		if(!Integer.toString(caregiver.getPhone()).isEmpty() ){
			cgDB.setPhone(caregiver.getPhone());
		}
		if(!caregiver.getStatus().isEmpty() && !" ".equalsIgnoreCase(caregiver.getStatus())){
			cgDB.setStatus(caregiver.getStatus());
		}
		
		return carerepo.save(cgDB);
	}
	public Caregiver fetchCaregiverByfirstName(String firstName) {
		// TODO Auto-generated method stub
		return carerepo.findByfirstName(firstName);
	}
	public Caregiver fetchCaregiverByfirsName(String firstName) {
		// TODO Auto-generated method stub
		return carerepo.findByfirstName(firstName);
	}
	public Caregiver fetchByfirstName(String firstName, Caregiver caregiver) {
		// TODO Auto-generated method stub
		 return carerepo.findByfirstName(firstName);
	}

	
     

	
	

}
