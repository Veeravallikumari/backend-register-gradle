package com.cts.Registration.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="users")
public class User {
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String firstName;
private String lastName;

private String emailId;
private String password;
private String confirmPassword;
private String address;


@ElementCollection(fetch = FetchType.LAZY)
private List<Caregiver> caregiver;



public List<Caregiver> getCaregiver() {
	return caregiver;
}

public void setCaregiver(List<Caregiver> caregiver) {
	this.caregiver = caregiver;
}

public User() {
}

public User(int id, String firstName, String lastName, String emailId, String password,String confirmPassword, String address ,List<Caregiver> caregiver) {
	super();
	
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.password = password;
	this.confirmPassword=confirmPassword;
	this.address = address;
	this.caregiver= caregiver;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getfirstName() {
	return firstName;
}
public void setfirstName(String firstName) {
	this.firstName = firstName;
}
public String getlastName() {
	return lastName;
}
public void setlatName(String lastName) {
	this.lastName = lastName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
