package com.budget.dao;

import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Phone;
import com.budget.domain.User;


public interface BudgetDao {
	
	List<User> findAllUsers();
	User findUser(String email, String password);
	User findUserByNumber(Phone number);
	User saveUser(User user);
	List<BudgetEntry> findEntriesByUser(long id);
	List<BudgetEntry> findAllEntries();
	Phone savePhone(Phone phone);
	Phone findPhone(String cCode, String aCode, String number);
}
