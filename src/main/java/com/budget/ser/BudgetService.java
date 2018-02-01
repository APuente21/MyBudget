package com.budget.ser;

import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Phone;
import com.budget.domain.User;

public interface BudgetService {
	
	User findUser(String email, String password);
	User findUserByNumber(Phone number);
	User saveUser(User user);
	List<User> findAllUsers();
	Phone savePhone(Phone phone);
	Phone findPhone(String cCode, String aCode, String number);
	List<BudgetEntry> findAllEntries();
	List<BudgetEntry> findEntriesByUser(long id);
}
