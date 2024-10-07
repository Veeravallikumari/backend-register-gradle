package com.cts.Registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Registration.model.Caregiver;
import com.cts.Registration.model.Login;
import com.cts.Registration.model.User;
import com.cts.Registration.service.CaregiverService;
import com.cts.Registration.service.RegistrationService;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private CaregiverService caregiverService;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception("user with "+tempEmailId+" is already exist");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;	
	}
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable String id){
		return service.fetchUserByEmailId(id);
	}
	
	@GetMapping("/getLogin/{id}")
	public Login getlogin(@PathVariable String id){
		User user=service.fetchUserByEmailId(id);
		return new Login(user.getEmailId(),user.getPassword());
	}
	@GetMapping("/getMember/{id}")
	public User getMember(@PathVariable int  id){
		return service.getUserById(id);
	}
	
	


	@PostMapping("/Caregiver")
	public Caregiver saveCaregiver(@RequestBody Caregiver caregiver) {
	   return caregiverService.saveCaregiver(caregiver);

   }
	
	@GetMapping("/Caregiver")
	public List<Caregiver > fetchCaregiverList(){
		return caregiverService.fetchCaregiverList();
		
	}
	
	@GetMapping("/Caregiver/{id}")
	public Caregiver fetchCaregiverById(@PathVariable("id") int id)  {
		return caregiverService.fetchCaregiverById(id);
		
	}
	
	@DeleteMapping("/Caregiver/{id}")
	public String deleteCaregiverById(@PathVariable("id") int id) {
	caregiverService.deleteCaregiverById(id);
		return "Caregiver Deleted Successfully";
		
	}
	
	@PostMapping("/updateCaregiver/{id}")
	public  Caregiver updateCaregiver(@PathVariable("id") int id, @RequestBody Caregiver caregiver ) {
		
		return caregiverService.updateCaregiver(id,caregiver);
		
	}
	
	@PostMapping("/user/{userId}/caregiver/{careId}")
	public Caregiver assignCareGiver( @PathVariable("userId")  int userId,@PathVariable("careId") int careId) throws Exception {
		return service.assignCareGiver(userId,careId);
	}
	
//	@GetMapping("/caregiver/firstname")
//	public Caregiver fetchByfirstName(@PathVariable("firstName") String firstName) {
//		return caregiverService.fetchCaregiverByfirstName(firstName);
//	}
	
	
	@GetMapping("/getCaregiver/{firstName}")
public  Caregiver fetchByfirstName(@PathVariable("firstName") String firstName, @RequestBody Caregiver caregiver ) {
		
		return caregiverService.fetchCaregiverByfirstName(firstName);
	

	}
	
	
}
