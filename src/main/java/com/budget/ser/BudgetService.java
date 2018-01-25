package com.budget.ser;

import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.User;

public interface BudgetService {
	List<BudgetEntry> findAllEntries();
	User findUser(String email, String password);
	User saveUser(User user);
	List<User> findAllUsers();
	List<BudgetEntry> findEntriesByUser(long id);
}
