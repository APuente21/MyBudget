package com.budget.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.budget.db.H2MemDB;
import com.budget.domain.User;
import com.budget.ser.BudgetService;

public class BudgetDaoImpTest {
	BudgetService budgetService;
	
	@Before
	public void setUpdateDB() {
		 ApplicationContext context= new ClassPathXmlApplicationContext("META-INF/spring/datasource-test.xml");
		 this.budgetService=  (BudgetService) context.getBean("budgetService");
	}
	
	@Test
	public void saveUserTest() {
		User userMock = mock(User.class);
		User saveUser(User user);
	}
	

	@Test
	public void findAllUsersTest() {
		List<User> allUsers = budgetService.findAllUsers();
		assertEquals(5, allUsers.size());
	}
	
}
