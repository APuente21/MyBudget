package com.budget.app;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.budget.dao.BudgetDao;
import com.budget.domain.BudgetEntry;
import com.budget.domain.User;


/*
 * In this program I am querying the database for all the books, without including the author
 * or the category. 
 * */
public class FindEntriesByUser {
	private static Logger logger = LoggerFactory.getLogger(
			FindEntriesByUser.class);
	
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
        
        List<BudgetEntry> entries = bDao.findEntriesByUser(user.getId());
        listBooks(entries);
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    
    //print all the books using logger
    private static void listBooks(List<BudgetEntry> entries) {
    	logger.info("");
    	logger.info("Listing book without details:");
    	for (BudgetEntry entry: entries) {
    		logger.info(entry.toString());
    		logger.info("");
    	}
    } 
}
