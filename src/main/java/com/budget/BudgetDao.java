package com.budget;

import java.util.List;


public interface BudgetDao {
	List<BudgetEntry> findAllEntries();
	List<User> findAllUsers();
	User findUser(String email, String password);
	List<BudgetEntry> findEntriesByUser(long id);
	User saveUser(User user);
}
