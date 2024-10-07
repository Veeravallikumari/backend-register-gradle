package com.cts.Registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cts.Registration.model.Caregiver;





@Repository
public interface CaregiverRepository  extends JpaRepository<Caregiver ,Integer>{

	public Caregiver findByfirstName(String firstName);




	


}
