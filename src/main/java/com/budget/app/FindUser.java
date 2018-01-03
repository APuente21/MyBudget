package com.budget.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.budget.dao.BudgetDao;
import com.budget.domain.User;


/*
 * Program to test retrieval of user given an email and password
 * */
public class FindUser {
	private static Logger logger = LoggerFactory.getLogger(
			FindUser.class);
	
    public static void main(String[] args) {
    	//Create the bean factory and load the bean
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context annotation.xml");
        ctx.refresh();
        
        //Instantiate the Data access object, by passing a bean for the PublishingDaoImp class.
        BudgetDao bDao = ctx.getBean("budgetDao", BudgetDao.class);
        //method queries the database and returns a list of all the books
        String email = "mgardout@gmail.com";
        String password = "gardoutpass";
        User user = bDao.findUser(email, password);
        logger.info("User with email: " + email + " password: " + password);  
        logger.info("-----------------------------------------------------");
        logger.info(user.toString());
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    
}
