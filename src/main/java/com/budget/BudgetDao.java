package com.budget;

import java.util.List;
import com.budget.BudgetEntry;
import com.budget.User;

public interface BudgetDao {
	List<BudgetEntry> findAllEntries();
	User findUser(String email, String password);
	List<BudgetEntry> findEntriesByUser(long id);
}
