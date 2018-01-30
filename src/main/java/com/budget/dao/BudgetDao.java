package com.budget.dao;

import java.util.List;

import com.budget.domain.BudgetEntry;
import com.budget.domain.User;


public interface BudgetDao {
	List<BudgetEntry> findAllEntries();
	List<User> findAllUsers();
	User findUser(String email, String password);
	User findUserByNumber(String number);
	List<BudgetEntry> findEntriesByUser(long id);
	User saveUser(User user);
}
