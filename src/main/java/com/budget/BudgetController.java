package com.budget;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 // Controller is responsible for processing HTTP requests


@Controller
public class BudgetController {
    private final Logger logger = LoggerFactory.getLogger(BudgetController.class);   
    private BudgetService budgetService;

    /*
     * The first request that is intercepted when a user first visits the site. It displays a login
     * form for the user.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView signIn() {
 	        
    	    return new ModelAndView("home", "user", new User());
    }
   
    /*
     * Intercepts the login request from the home screen and checks to see if the user is in the database
     */
    @RequestMapping (method = RequestMethod.POST)
    public String logInCheck(@Valid @ModelAttribute("user")User user, 
    		BindingResult result, ModelMap model) {
    	    if (result.hasErrors()) {
    	           return "error";
    	    }
    	    User reguisteredUser = budgetService.findUser(user.getEmail(), user.getPassword());    	   
    	    
    	    if (reguisteredUser != null) {
    	    	return "redirect:/users";
    	    }
    	    else 
    	    	return "redirect:/";
    }
    
    /*
     * HTTP request that is intercepted when a user clicks on register button on the home page. The
     * method maps a new user to the register.jsp form, which is returned to the browser
     */
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registerForm() {
    	    return new ModelAndView("register", "user", new User());
    }
    
    
    /*
     * Saves the new user into the database, after which it sends a twilio message to that phone number
     */
    @RequestMapping (value="/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user")User user, 
    		BindingResult result, ModelMap model) {
    	    if (result.hasErrors()) {
    	           return "error";
    	    }
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
    
	
}
