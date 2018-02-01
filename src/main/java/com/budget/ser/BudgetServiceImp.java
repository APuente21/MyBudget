package com.budget.ser;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.budget.dao.BudgetDao;
import com.budget.domain.BudgetEntry;
import com.budget.domain.Phone;
import com.budget.domain.User;
	

@Service
public class BudgetServiceImp implements BudgetService {
	private BudgetDao budgetDao;
	
	public void setBudgetDao(BudgetDao budgetDao) {
		this.budgetDao= budgetDao;
	}
	
	@Transactional
	public List<BudgetEntry> findAllEntries() {
		return this.budgetDao.findAllEntries();
	}
	
	@Transactional
	public List<User> findAllUsers() {
		return this.budgetDao.findAllUsers();
	}
	
	public User saveUser(User user) {
		return this.budgetDao.saveUser(user);
	}
	
	public Phone savePhone(Phone phone) {
		return this.budgetDao.savePhone(phone);
	}

	@Transactional
	public User findUser(String email, String password) {
		return this.budgetDao.findUser(email, password);
	}
	
	@Transactional
	public User findUserByNumber(Phone number) {
		return this.budgetDao.findUserByNumber(number);
	}

	@Transactional
	public Phone findPhone(String cCode, String aCode, String number) {
		return this.budgetDao.findPhone(cCode, aCode, number);
	}
	
	@Transactional
	public List<BudgetEntry> findEntriesByUser(long id) {
		return this.budgetDao.findEntriesByUser(id);
	}

}
