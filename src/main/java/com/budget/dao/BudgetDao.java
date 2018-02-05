package com.budget.dao;

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
	
	//CRUD operations related to the BudgetEntry class
	//List<BudgetEntry> findEntriesByUser(long id);
	List<BudgetEntry> findAllEntries();
	BudgetEntry saveBudgetEntry(BudgetEntry bEntry);
	
	//CRUD operations related to the Phone class
	Phone savePhone(Phone phone);
	Phone findPhone(String cCode, String aCode, String number);
	
	//CRUD operations related to the Category class
	Category findCategory(String name);
	Category saveCategory(Category category);
}
