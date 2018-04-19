package com.budget.dao;

import java.util.Date;
import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.User;


public interface BudgetDao {
	//CRUD operations related to the User class
	List<User> findAllUsers();
	User findUser(String email, String password);
	User findUserByNumber(Phone number);
	User saveUser(User user);
	void deleteUser(User user);
	
	//CRUD operations related to the BudgetEntry class
	List<Object[]> findEntriesByUser(User user);
	List<Object[]> findEntriesByUserDate(User user, Date date);
	List<BudgetEntry> findAllEntries();
	BudgetEntry saveBudgetEntry(BudgetEntry bEntry);
	
	//CRUD operations related to the Phone class
	Phone savePhone(Phone phone);
	Phone findPhone(String cCode, String aCode, String number);
	void deletePhone(Phone phone);
	
	//CRUD operations related to the Category class
	Category findCategory(String name);
	Category saveCategory(Category category);
}
