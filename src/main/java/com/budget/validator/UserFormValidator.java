package com.budget.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.budget.domain.User_Phone_Wrapper;


@Component
public class UserFormValidator implements Validator {
	
	@Autowired
	@Qualifier("emailValidator")
	public EmailValidator emailValidator;
	
	@Autowired
	@Qualifier("phoneValidator")
	public PhoneValidator phoneValidator;

	public boolean supports(Class<?> clazz) {
		return User_Phone_Wrapper.class.equals(clazz);
	}


	public void validate(Object target, Errors errors) {

		User_Phone_Wrapper wrapper = (User_Phone_Wrapper) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "areaCode", "NotEmpty.userForm.areaCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.userForm.countryCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "NotEmpty.userForm.number");
		

		if(!emailValidator.valid(wrapper.getEmail())){
			errors.rejectValue("email", "Pattern.email");
		}
		
		boolean ccError = errors.hasFieldErrors("countryCode");
		boolean acError = errors.hasFieldErrors("areaCode");
		boolean nError = errors.hasFieldErrors("number");
		
		if(!ccError & !acError & !nError) {
			phoneValidator.setCountryCode(wrapper.getCountryCode());
			phoneValidator.setAreaCode(wrapper.getAreaCode());
			phoneValidator.setNumber(wrapper.getNumber());
		
			if(!phoneValidator.validCountryCode())
				errors.rejectValue("countryCode", "Pattern.userForm.countryCode");
			else 
				wrapper.setCountryCode(phoneValidator.getCountry());
			
			
			if(!phoneValidator.validAreaCode())
				errors.rejectValue("areaCode", "Pattern.userForm.areaCode");
			else
				wrapper.setAreaCode(phoneValidator.getArea());
			
			if(!phoneValidator.validNumber())
				errors.rejectValue("number", "Pattern.userForm.number");
			else
				wrapper.setNumber(phoneValidator.getNumber());
		}
		boolean s = false;
		
	}

}