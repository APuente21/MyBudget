package com.budget.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.User;
import com.budget.ser.BudgetService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSHandler {
	  public static final String ACCOUNT_SID = "Axxxx";
	  public static final String AUTH_TOKEN = "65";
	  private BudgetService budgetService;
	  private User user;
	  private BudgetEntry bEntry;
	  private Category category;
	  private String txtNumber;
	  private String txtBody;
	  
	  
	  public SMSHandler() {}
	  
	  public SMSHandler(String number, String body) {
		  this.txtNumber = number;
		  this.txtBody = body;
	  }
	  
	  public void getUser() {
		  this.user = budgetService.findUserByNumber(txtNumber);
	  }
	  
	  public void sendConfirmationSMS() {
		  String msg = "Your entry was successfully loaded";
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		  Message message = Message.creator(
				  new PhoneNumber(txtNumber),//From number
				  new PhoneNumber("+19172439262 "), //twilio number
				  msg).create();

		  System.out.println(message.getSid());
	  } 
	  
	@Autowired(required=true)
	@Qualifier(value="budgetService")
	public void setBudgetService(BudgetService budgetService) {
		this.budgetService = budgetService;
	}
	
	
}
