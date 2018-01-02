
package com.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
	public static final String ACCOUNT_SID = "ACd5c03dde5f56202f6422d1becf6662d3";
	public static final String AUT_TOKEN = "651c689c81408b303876af7362f576b7";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Twilio.init(ACCOUNT_SID, AUT_TOKEN);
		
		Message message = Message.creator(
				new PhoneNumber("+15168301709"),
				new PhoneNumber("+19172439262"),
				"HEY PETRUSHKA").create();
		
		System.out.println(message.getSid());
	}

}
