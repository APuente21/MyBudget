package com.budget.twilio;

import static org.junit.Assert.*;

import org.junit.Test;

public class SMSHandlerTest {

	@Test
	public void processRequestTest() {
		
		SMSHandler handler = new SMSHandler();
		assertTrue(handler.isBudgetServiceNull());
	}

}
