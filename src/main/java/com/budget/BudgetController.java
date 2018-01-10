package com.budget;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 9. The annotation @Controller is applied to the class, indicating that it’s a Spring MVC controller. 
 * The @RequestMapping annotation at the class level indicates the relative URL that will be handled 
 * by the controller. 
 * In this case, all URLs with the prefix /contact-webapp-1/contacts will be dispatched to this controller.
 */
@RequestMapping("/contacts")
@Controller
public class BudgetController {
    private final Logger logger = LoggerFactory.getLogger(BudgetController.class);

    private BudgetDao budgetDao;

    /* The URL /contact-webapp-1/contacts with the HTTP GET method will be handled by this method
     * The list of contacts are retrieved and saved into the Model interface passed 
     * in to the method by Spring MVC. Finally, the logical view name contacts/list is returned.
     * In the DispatcherServlet configuration, the InternalResourceViewResolver is configured 
     * as the view resolver, and the file has the prefix /WEB-INF/views/ and the suffix .jspx. 
     * As a result, Spring MVC will pick up the file /WEB-INF/views/contacts/list.jspx as the view.
     * This is the next step.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing contacts");
        
        String s1 = "password";
        String s2 = "user";
       // User user = budgetDao.findUser(s1,s2);
        
        //Bind List<Contact> to Model, that will be displayed by View.
        //uiModel.addAttribute("user", user);

        return "contacts/list";
    }
   
    @Autowired
    public void setBudgetDao(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

}
