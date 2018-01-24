package com.budget;

import java.util.List;

public interface BudgetService {
	List<BudgetEntry> findAllEntries();
	User findUser(String email, String password);
	User saveUser(User user);
	List<User> findAllUsers();
	List<BudgetEntry> findEntriesByUser(long id);
}
