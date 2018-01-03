package com.budget.dao;

import java.util.List;
import com.budget.domain.BudgetEntry;

public interface BudgetDao {
	List<BudgetEntry> findAllEntries();
}
