package com.budget.dao;

import java.util.List;
import com.budget.domain.BudgetEntry;
import com.budget.domain.User;

public interface BudgetDao {
	List<BudgetEntry> findAllEntries();
	User findUser(String email, String password);
	List<BudgetEntry> findEntriesByUser(long id);
}
