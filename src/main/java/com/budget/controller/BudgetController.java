

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.budget.domain.Phone;
import com.budget.domain.User;
import com.budget.domain.User_Phone_Wrapper;
import com.budget.ser.BudgetService;
import com.budget.validator.LogInFormValidator;
import com.budget.validator.UserFormValidator;


 // Controller is responsible for processing HTTP requests


@Controller
public class BudgetController {
    private final Logger logger = LoggerFactory.getLogger(BudgetController.class);   
    private BudgetService budgetService;
    private UserFormValidator userFormValidator;
  
    
    @InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
    
   
    //* HTTP request that is intercepted when a user clicks on register button on the home page. The
    // * method maps a new user to the register.jsp form, which is returned to the browser
     
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registerForm() {
    	    return new ModelAndView("register", "user", new User_Phone_Wrapper());
    }
    
    
    
     //* Saves the new user into the database, after which it sends a twilio message to that phone number
    
    @RequestMapping (value="/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user")User_Phone_Wrapper wrapper, 
    		BindingResult result, ModelMap model) {
    	    if (result.hasErrors()) {
    	           return "register";
    	    }
    	    
    	    //Check to see if phone number is already in the system. If so return error message
    	    Phone phone = budgetService.findPhone(wrapper.getCountryCode(), wrapper.getAreaCode(), wrapper.getNumber());
    	    if( phone != null) {
    	    	result.rejectValue("number", "Duplicate.userForm.number", "Duplicate number");
    	    	return "register";
    	    }
    	    
    	    phone = new Phone(wrapper.getCountryCode(), wrapper.getAreaCode(), wrapper.getNumber());
    	    phone = budgetService.savePhone(phone);
    	    User user = new User();
    	    user.setEmail(wrapper.getEmail());
    	    user.setFirstName(wrapper.getFirstName());
    	    user.setLastName(wrapper.getLastName());
    	    user.setPassword(wrapper.getPassword());
    	    user.setNumber(phone);
    	    
    	    budgetService.saveUser(user);
   	    	return "redirect:/users";

    }
      
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView get() {
        logger.info("Listing contacts");
       

        List<User> users = budgetService.findAllUsers();
        logger.info("Listing contacts");
      
        return new ModelAndView("list", "users", users);
    }
    
    
	@Autowired(required=true)
	@Qualifier(value="budgetService")
    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
    
	@Autowired(required=true)
	@Qualifier(value="userFormValidator")
    public void setUserValidator(UserFormValidator userFormValidator) {
        this.userFormValidator = userFormValidator;
    }
}

