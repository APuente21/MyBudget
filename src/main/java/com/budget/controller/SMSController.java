package com.budget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.budget.twilio.SMSHandler;

@Controller
public class SMSController {
	   private final Logger logger = LoggerFactory.getLogger(SMSController.class);   
	   
	    @RequestMapping(value="/sms", method = RequestMethod.POST)
	    public void processMsg (@RequestParam("From") String fromNumber, @RequestParam("Body") String txtBody) {
	    	SMSHandler smsHandler = new SMSHandler(fromNumber, txtBody);
	    	smsHandler.sendConfirmationSMS();	
	    }
}
