
package com.budget.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.budget.domain.User;
import com.budget.ser.BudgetService;
import com.budget.validator.LogInFormValidator;


 // Controller is responsible for intercepting requests to the home page and performing user
 //authentication


@Controller
public class LogInController {
    private final Logger logger = LoggerFactory.getLogger(LogInController.class);  
    private BudgetService budgetService;
    private LogInFormValidator logInFormValidator;
    
    
    @InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(logInFormValidator);
	}
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView signIn() {
    	 return new ModelAndView("home", "user", new User());
    }
   

    @RequestMapping (method = RequestMethod.POST)
    public String logInCheck(@Valid @ModelAttribute("user")User user, 
    	BindingResult result, ModelMap model) {
    	if (result.hasErrors()) {
    		return "home";
    	}
    	User reguisteredUser = budgetService.findUser(user.getEmail(), user.getPassword());    	   
    	    
    	if (reguisteredUser != null) {
    		return "redirect:/users";
    	}
    	else {
    	    	result.rejectValue("number", "Incorrect.logInForm.password", "Incorrect username/password");
    	  	return "home";
    	}
    	    	
    }
    
	@Autowired(required=true)
	@Qualifier(value="budgetService")
    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
	
	@Autowired(required=true)
	@Qualifier(value="logInFormValidator")
    public void setValidator(LogInFormValidator logInFormValidator) {
        this.logInFormValidator = logInFormValidator;
    }

}

