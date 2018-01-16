package com.budget;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
	

@Service
public class BudgetServiceImp implements BudgetService {
	private BudgetDao budgetDao;
	
	public void setBudgetDao(BudgetDao budgetDao) {
		this.budgetDao= budgetDao;
	}
	
	@Transactional
	@Override
	public List<BudgetEntry> findAllEntries() {
		return this.budgetDao.findAllEntries();
	}

	@Transactional
	@Override
	public User findUser(String email, String password) {
		return this.budgetDao.findUser(email, password);
	}

	@Transactional
	@Override
	public List<BudgetEntry> findEntriesByUser(long id) {
		return this.budgetDao.findEntriesByUser(id);
	}

}
