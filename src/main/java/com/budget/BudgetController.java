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

/**
 * 9. The annotation @Controller is applied to the class, indicating that it’s a Spring MVC controller. 
 * The @RequestMapping annotation at the class level indicates the relative URL that will be handled 
 * by the controller. 
 * In this case, all URLs with the prefix /contact-webapp-1/contacts will be dispatched to this controller.
 */


@Controller
public class BudgetController {
    private final Logger logger = LoggerFactory.getLogger(BudgetController.class);   
    private BudgetService budgetService;

    /* The URL /contact-webapp-1/contacts with the HTTP GET method will be handled by this method
     * The list of contacts are retrieved and saved into the Model interface passed 
     * in to the method by Spring MVC. Finally, the logical view name contacts/list is returned.
     * In the DispatcherServlet configuration, the InternalResourceViewResolver is configured 
     * as the view resolver, and the file has the prefix /WEB-INF/views/ and the suffix .jspx. 
     * As a result, Spring MVC will pick up the file /WEB-INF/views/contacts/list.jspx as the view.
     * This is the next step.
     */
    
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
    	    model.addAttribute("firstName", user.getFirstName());
    	    model.addAttribute("number", user.getNumber());
    	    model.addAttribute("email", user.getEmail());
    	    logger.info("User id: " + user.getId());
    	        
    	    return "redirect:/";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView get() {
        logger.info("Listing contacts");
       

        List<User> users = budgetService.findAllUsers();
        logger.info("Listing contacts");
      
        return new ModelAndView("list", "users", users);
    }
    

    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user")User user, 
    		BindingResult result, ModelMap model) {
    	    if (result.hasErrors()) {
    	           return "error";
    	    }
    	    model.addAttribute("firstName", user.getFirstName());
    	    model.addAttribute("number", user.getNumber());
    	    model.addAttribute("email", user.getEmail());
    	    logger.info("User id: " + user.getId());
    	        
    	    return "redirect:/";
    }
   
    
	@Autowired(required=true)
	@Qualifier(value="budgetService")
    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
    
	
}
