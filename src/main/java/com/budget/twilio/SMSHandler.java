package com.budget.twilio;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.Request;
import com.budget.domain.User;
import com.budget.ser.BudgetService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSHandler {
	  public static final String ACCOUNT_SID = "";
	  public static final String AUTH_TOKEN = "";
	  private BudgetService budgetService;
	  private User user;
	  private BudgetEntry bEntry;
	  private Category category;
	  private String txtNumber;
	  private String txtBody;
	  private Phone phone;
	  private String msg;
	  private Request request;
	  
	  
	  public SMSHandler() {}
	  
	  public SMSHandler(String number, String body, BudgetService bService) {
		  this.txtNumber = number;
		  this.txtBody = body;
		  this.budgetService = bService;
		  this.request = new Request(body);
		  this.request.loadRequest();
		  //Get Phone and User
		  String[] digits = Phone.getDigits(txtNumber);
		  phone = budgetService.findPhone(digits[0], digits[1], digits[2]);
		  user = budgetService.findUserByNumber(phone);
		  
		  
	  }
	  
	  public void processRequest() {
		  if(request.hasException())
			  sendConfirmationSMS(request.getException());
		  else {
			  if(request.isBalanceRequest()) {
				  sendConfirmationSMS("test");
				  
				  //write code to get balance request
			  } else {
				  //write code to save budget category
			  }
			  
		  }
	  }
	  
	  public boolean saveEntry() {
		 this.bEntry = new BudgetEntry();
		 bEntry.setAmount(this.request.getAmount());
		 bEntry.setUser(this.user);
		 bEntry.setDescription(this.request.getDescription());
		  
		  /*
		   * Check if request has a category. If it does, check the database if the category already exisits. If it does
		   * add the category to the budgetentry class. If it doesn't exist, then create a new category class, and save it 
		   * to the database, after which we add it to the budgetEntry class
		   */
		 if(request.hasCategory()) {
			 category = budgetService.findCategory(request.getCategory().toUpperCase());
			 if (category == null) {
				 category = new Category();
				 category.setName(request.getCategory().toUpperCase());
				 category = budgetService.saveCategory(category);
				 bEntry.setCategory(category);
			 } else {
				 bEntry.setCategory(category);
			 }
			 
		 }
		  
		 Date date = new Date();
		 bEntry.setDate(date);

		 bEntry = budgetService.saveBudgetEntry(bEntry);
		 
		 bEntry.setUser(this.user);
		 return (bEntry== null)? false: true;
	  }

	  public void sendConfirmationSMS(String msg) {
		  this.msg = "msg";
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		  Message message = Message.creator(
				  new PhoneNumber(txtNumber),//From number
				  new PhoneNumber("+19172439262 "), //twilio number
				  msg).create();

		  System.out.println(message.getSid());
	  } 
	  

	
}
