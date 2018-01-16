package com.budget;

import java.util.List;

public interface BudgetService {
	List<BudgetEntry> findAllEntries();
	User findUser(String email, String password);
	List<BudgetEntry> findEntriesByUser(long id);
}
