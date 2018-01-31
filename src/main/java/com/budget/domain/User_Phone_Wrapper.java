package com.budget.domain;


public class User_Phone_Wrapper {
	private String countryCode;
	private String areaCode;
	private String number;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	public void setCountryCode(String input) {
		this.countryCode = input;
	}
	
	public void setAreaCode(String input) {
		this.areaCode = input;
	}
	
	public void setNumber(String input) {
		this.number = input;
	}
	
	public String getCountryCode() {
		return this.countryCode;
	}
	
	public String getAreaCode() {
		return  this.areaCode;
	}
	
	public String getNumber() {
		return this.number;
	}
	

	//|||||||||||||||||||||||||
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
    
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
	public String getLastName() {
		return this.lastName;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
    
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

}
