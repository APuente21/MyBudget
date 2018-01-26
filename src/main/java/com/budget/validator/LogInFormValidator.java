package com.budget.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.budget.domain.User;
import com.budget.ser.BudgetService;

/*
 * Custom validator that is used to validate the login form. The validator is passed
 * to the LogInFOrm controller
 */

@Component
public class LogInFormValidator implements Validator {	

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}


	public void validate(Object target, Errors errors) {

		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.logInForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.logInForm.password");

		if(!emailValidator.valid(user.getEmail())){
			errors.rejectValue("email", "Pattern.logInForm.email");
		}
		

	}

}