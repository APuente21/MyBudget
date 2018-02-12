package com.budget.validator;
import org.springframework.stereotype.Component;

@Component("phoneValidator")
public class PhoneValidator {
	private StringBuilder countryCode;
	private StringBuilder areaCode;
	private StringBuilder number;
	
	public PhoneValidator() {}
	
	public boolean validCountryCode() {
		for(int x= 0; x < countryCode.length(); x++) {
			if (!Character.isDigit(countryCode.charAt(x)))
				countryCode.deleteCharAt(x);
		}
		return (countryCode.length() > 0)? true: false;

	}
	
	public boolean validAreaCode() {
		for(int x= 0; x < areaCode.length(); x++) {
			if (!Character.isDigit(areaCode.charAt(x)))
				areaCode.deleteCharAt(x);
		}
		return (areaCode.length() == 3)? true: false;
	}
	
	public boolean validNumber() {
		for(int x= 0; x < number.length(); x++) {
			if (!Character.isDigit(number.charAt(x)))
				number.deleteCharAt(x);
		}
		return (number.length() == 7)? true: false;
	}
	
	public void setCountryCode(String cIn) {
		this.countryCode = new StringBuilder(cIn);
	}
	
	public void setAreaCode(String aIn) {
		areaCode = new StringBuilder(aIn);
	}
	
	public void setNumber(String nIn) {
		number = new StringBuilder(nIn);
	}
	
	public String getCountry() {
		return countryCode.toString();
	}
	
	public String getArea() {
		return areaCode.toString();
	}
	
	public String getNumber() {
		return number.toString();
	}
}
