package com.budget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.budget.domain.Phone;
import com.budget.ser.BudgetService;
import com.budget.twilio.SMSHandler;

@Controller
public class SMSController {
	   private final Logger logger = LoggerFactory.getLogger(SMSController.class);   
	   private BudgetService budgetService;
	   
	    @RequestMapping(value="/sms", method = RequestMethod.POST)
	    public void processMsg (@RequestParam("From") String fromNumber, @RequestParam("Body") String txtBody) {
	    	

	    	SMSHandler smsHandler = new SMSHandler(fromNumber, txtBody, budgetService);
	    	smsHandler.sendConfirmationSMS();	
	    }
	    
		@Autowired(required=true)
		@Qualifier(value="budgetService")
		public void setBudgetService(BudgetService budgetService) {
			this.budgetService = budgetService;
		}
		
}
