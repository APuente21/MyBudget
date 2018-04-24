package com.budget.ser;

import java.util.Date;
import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.User;

public interface BudgetService {
	
	//Related to User Class
	User findUser(String email, String password);
	User findUserByNumber(Phone number);
	User findUserById(Long id);
	User saveUser(User user);
	List<User> findAllUsers();
	void deleteUser(User user);
	//need to create a delete user
	
	//Related to BudgetEntry Class
	List<BudgetEntry> findAllEntries();
	List<Object[]> findEntriesByUser(User user);
	List<Object[]> findEntriesByUserDate(User user, Date date);
	BudgetEntry saveBudgetEntry(BudgetEntry bEntry);
	List<BudgetEntry> findEntriesByUserDateNoAggregation(User user, Date date);
	//need to create a delete BE
	
	//Related to Phone Class
	Phone savePhone(Phone phone);
	Phone findPhone(String cCode, String aCode, String number);
	void deletePhone(Phone phone);

	//Related to Category Class
	Category findCategory(String name);
	Category saveCategory(Category category);
	//need to create a delete category
}
