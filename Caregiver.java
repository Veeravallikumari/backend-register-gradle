package com.cts.Registration.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="caregivers")
public class Caregiver{


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
    private String address;
    private int  phone;
    private String status="Assign";
    
    





	public Caregiver()
	{
		
	}
	
	

	public Caregiver(int id, String firstName, String lastName, String emailId, String address , int phone, String status ) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
		this.phone = phone;
		this.status = status;
//		this.careTaker = careTaker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Caregiver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", address=" + address + ", phone=" + phone + ", status=" + status + "]";
	}



	


	



	


}
