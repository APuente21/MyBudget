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
		
	}

}