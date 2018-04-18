package com.budget.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.budget.domain.Phone;
import com.budget.domain.User;
import com.budget.ser.BudgetService;

public class BudgetDaoImpTest {
	private static BudgetService budgetService;
	
	@BeforeClass
	public static void setUpdateDB() {
		 ApplicationContext context= new ClassPathXmlApplicationContext("META-INF/spring/datasource-test.xml");
		 budgetService=  (BudgetService) context.getBean("budgetService");
	}
	
	
	//|||||||||||||||||||||||||||TEST RELATED TO USERS|||||||||||||||||||||||||||
	@Test
	public void findUserTest() {
		User testUser = budgetService.findUser("abrovo@gmail.com", "brabopass");
		assertEquals("Andres", testUser.getFirstName());
	}
	
	@Test
	public void findAllUsersTest() {
		List<User> allUsers = budgetService.findAllUsers();
		assertEquals(5, allUsers.size());
	}
	
	@Test
	public void findUserByPhoneTest() {
		Phone phone = budgetService.findPhone("1", "516", "8301708");
		User testUser = budgetService.findUserByNumber(phone);
		assertEquals("abrovo@gmail.com", testUser.getEmail());
	}
	@Test
	public void deleteUserTest(){
		User testUser = budgetService.findUser("mgardout@gmail.com", "gardoutpass");
		budgetService.deleteUser(testUser);
		User deletedUser = budgetService.findUser("mgardout@gmail.com", "gardoutpass");
		assertNull(deletedUser);
	}
	
	
	@Test
	@Transactional
    @Rollback(true)
	public void saveUserTest() {
		User testUser = new User();
		testUser.setFirstName("first");
		testUser.setLastName("last");
		testUser.setNumber(new Phone("1","212","6667777"));
		testUser.setEmail("email@gmail.com");
		testUser.setPassword("password");
		testUser = budgetService.saveUser(testUser);
		User savedUser = budgetService.findUser("email@gmail.com", "password");
		assertEquals("Check if user was saved to db",savedUser.getEmail(), testUser.getEmail());		
	}
	
	//|||||||||||||||||||||||||||TEST RELATED TO PHONE|||||||||||||||||||||||||||

	@Test
	public void findPhoneTest() {
		Phone phone = budgetService.findPhone("1", "516", "8301708");
		assertEquals("8301708", phone.getNumber());
	}
	
	@Test
	public void savePhoneTest() {
		Phone phone = new Phone("1", "516", "8301799");
		phone = budgetService.savePhone(phone);
		Phone savedPhone = budgetService.findPhone("1", "516", "8301799");
		assertEquals("8301799", savedPhone.getNumber());
	}
	
	//|||||||||||||||||||||||||||TEST RELATED TO CATEGORY|||||||||||||||||||||||||||
	
}
