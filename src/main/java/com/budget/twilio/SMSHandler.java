package com.budget.twilio;

import java.util.Date;
import java.util.List;
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
	  public static final String ACCOUNT_SID = "ACd5c03dde5f56202f6422d1becf6662d3";
	  public static final String AUTH_TOKEN = "651c689c81408b303876af7362f576b7";
	  private BudgetService budgetService;
	  private User user;
	  private BudgetEntry bEntry;
	  private Category category;
	  private String txtNumber;
	  private String txtBody;
	  private Phone phone;
	  private String msg;
	  private Request request;
	  private boolean newUser= false;
	    
	  public SMSHandler() {}
	  
	  public SMSHandler(String number, boolean newUser) {
		  this.txtNumber = number;  
		  this.newUser = newUser;
	  }
	  
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
			  if(this.newUser) {
				  sendConfirmationSMS("Welcome to MyBudget!!");
			  } else if(request.isBalanceRequest()) {
				  sendConfirmationSMS(getBalance());
			  } else {
				  if (saveEntry())
					  sendConfirmationSMS("Your request was successfully processed");
				  else
					  sendConfirmationSMS("We were unable to process your request");
			  }
			  
		  }
	  }
	  
	  @SuppressWarnings("deprecation")
	public String getBalance() {
	        Date d = new Date();
	        d.setDate(1);
	   
	        List<Object[]> test = budgetService.findEntriesByUserDate(user, d);
	        double total = 0;
	        String response = "";
	        for (Object[] input: test) {
	        	if(input[0] == null) {
	        		response = response + "DEFAULT: $" + input[1].toString() + "\n";
	        		total = total + (Double)input[1];
	        	} else {
	        		response = response + ((Category)input[0]).getName() + ": $" + (String) input[1].toString() + "\n";
	        		total = total + (Double)input[1];
	        	}
	        }
	        
	        response = response + "\nTotal: $" + total;
	        return response;
	        
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
