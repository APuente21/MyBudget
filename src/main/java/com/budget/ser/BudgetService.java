package com.budget.ser;

import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.User;

public interface BudgetService {
	
	//Related to User Class
	User findUser(String email, String password);
	User findUserByNumber(Phone number);
	User saveUser(User user);
	List<User> findAllUsers();
	
	//Related to BudgetEntry Class
	List<BudgetEntry> findAllEntries();
	List<BudgetEntry> findEntriesByUser(long id);
	BudgetEntry saveBudgetEntry(BudgetEntry bEntry);
	
	//Related to Phone Class
	Phone savePhone(Phone phone);
	Phone findPhone(String cCode, String aCode, String number);

	//Related to Category Class
	Category findCategory(String name);
	Category saveCategory(Category category);
}
