package com.budget.domain;


public class Request {
	private boolean balanceRequest = false;
	private double amount;
	private String description;
	private String category;
	private boolean hasCategory = false;
	private String request;
	private boolean hasException = false;
	private String exceptionMsg;
	
	public Request(String request) {
		this.request = request;
	}
	
	public void loadRequest() {
    	try {
    		if (request.substring(0, 7).toLowerCase().equals("balance")) {
    	   		balanceRequest = true;
    	   	} else {
    			this.setAmount();
    			this.setDescription();
    			this.setCategory();
    	   	}
    	} catch (IllegalArgumentException e) {
    		this.hasException = true;
    		exceptionMsg = e.getMessage();
    	}
	}
	
	private void setAmount() throws IllegalArgumentException{
		String digit = this.request.substring(0, this.request.indexOf(' '));
		if (Character.isDigit(digit.charAt(0)) || digit.charAt(0) == '.')
			this.amount= (Double.valueOf(digit));
		else {
			if (digit.charAt(0) == '$') {
				digit = digit.substring(1);
				this.amount = (Double.valueOf(digit));
			} else
				throw new IllegalArgumentException("Incorrect number format");
		}
	} 
	
	private void setDescription() {
		if(this.request.indexOf("C:") != -1) 
			this.description =  this.request.substring(this.request.indexOf(' ') +1 , this.request.indexOf("C:") -1);		
		else if (this.request.indexOf("c:") != -1)
			this.description = this.request.substring(this.request.indexOf(' ') +1 , this.request.indexOf("c:") -1);
		else
			this.description = this.request.substring(this.request.indexOf(' ') + 1 );
			
	}
	
	private void setCategory() {
		if (this.request.indexOf("c:") != -1) {
			this.hasCategory = true;
			this.category = this.request.substring(this.request.indexOf("c:") + 3);
		}
		else if (this.request.indexOf("C:") != -1){
			this.hasCategory = true;
			this.category = this.request.substring(this.request.indexOf("C:") + 3);
		}	
	}
	
	public boolean hasCategory() {
		return this.hasCategory;
	}
	
	public boolean hasException() {
		return this.hasException;
	}
	
	public String getException() {
		return this.exceptionMsg;
	}
	
	public boolean isBalanceRequest() {
		return this.balanceRequest;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCategory() {
		return this.category;
	}
		
}
