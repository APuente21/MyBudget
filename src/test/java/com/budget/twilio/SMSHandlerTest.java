package com.budget.twilio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.budget.db.H2MemDB;

public class SMSHandlerTest {

	@Test
	public void processRequestTest() {
		H2MemDB db = new H2MemDB();
		
		SMSHandler handler = new SMSHandler();
		assertTrue(handler.isBudgetServiceNull());
	}

}
