package com.budget.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.User;
import com.budget.ser.BudgetService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSHandler {
	  public static final String ACCOUNT_SID = "ACd5c03dde5f56202f6422d1becf6662d3";
	  public static final String AUTH_TOKEN = "651c689c81408b303876af7362f576b7";
	  private BudgetService budgetService;
	  private User user;
	  private BudgetEntry bEntry;
	  private Category category;
	  private String txtNumber;
	  private String txtBody;
	  private Phone phone;
	  
	  
	  public SMSHandler() {}
	  
	  public SMSHandler(String number, String body, BudgetService bService) {
		  this.txtNumber = number;
		  this.txtBody = body;
		  this.budgetService = bService;
		  
		  //Get Phone and User
		  String[] digits = Phone.getDigits(txtNumber);
		  phone = budgetService.findPhone(digits[0], digits[1], digits[2]);
		  user = budgetService.findUserByNumber(phone);
		  
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
	  

	
}
