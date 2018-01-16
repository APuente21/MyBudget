package com.budget;

import java.util.List;


public interface BudgetDao {
	List<BudgetEntry> findAllEntries();
	User findUser(String email, String password);
	List<BudgetEntry> findEntriesByUser(long id);
}
