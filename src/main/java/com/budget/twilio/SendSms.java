
package com.budget.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
	public static final String ACCOUNT_SID = "********";
	public static final String AUT_TOKEN = "*******";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Twilio.init(ACCOUNT_SID, AUT_TOKEN);
		
		Message message = Message.creator(
				new PhoneNumber("********"),
				new PhoneNumber("********"),
				"HEY PETRUSHKA").create();
		
		System.out.println(message.getSid());
	}

}