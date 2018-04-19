package com.budget.ser;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.budget.dao.BudgetDao;
import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.User;
	

@Service
public class BudgetServiceImp implements BudgetService {
	private BudgetDao budgetDao;
	
	public void setBudgetDao(BudgetDao budgetDao) {
		this.budgetDao= budgetDao;
	}
	
	//|||||||||||||||||||||||||||||||||||||||RELATED TO USER CLASS||||||||||||||||||||||||||||||||||||||||||||||
	@Transactional
	public List<User> findAllUsers() {
		return this.budgetDao.findAllUsers();
	}
	
	public User saveUser(User user) {
		return this.budgetDao.saveUser(user);
	}

	@Transactional
	public User findUser(String email, String password) {
		return this.budgetDao.findUser(email, password);
	}
	
	@Transactional
	public void deleteUser(User user) {
		this.budgetDao.deleteUser(user);
	}
	
	@Transactional
	public User findUserByNumber(Phone number) {
		return this.budgetDao.findUserByNumber(number);
	}

	//|||||||||||||||||||||||||||||||||||||||RELATED TO BUDGETENTRY CLASS||||||||||||||||||||||||||||||||||||||||||||||
	
	@Transactional
	public List<BudgetEntry> findAllEntries() {
		return this.budgetDao.findAllEntries();
	}
	
	
	@Transactional
	public List<Object[]> findEntriesByUser(User user) {
		return this.budgetDao.findEntriesByUser(user);
	}
	
	@Transactional
	public List<Object[]> findEntriesByUserDate(User user, Date date) {
		return this.budgetDao.findEntriesByUserDate(user, date);
	}
	
	
	@Transactional
	public BudgetEntry saveBudgetEntry(BudgetEntry bEntry) {
		return this.budgetDao.saveBudgetEntry(bEntry);
	}
	
	//|||||||||||||||||||||||||||||||||||||||RELATED TO PHONE CLASS||||||||||||||||||||||||||||||||||||||||||||||
	
	@Transactional
	public Phone findPhone(String cCode, String aCode, String number) {
		return this.budgetDao.findPhone(cCode, aCode, number);
	}
	
	public Phone savePhone(Phone phone) {
		return this.budgetDao.savePhone(phone);
	}
	
	@Transactional
	public void deletePhone(Phone phone) {
		this.budgetDao.deletePhone(phone);
	}
	
	
	//|||||||||||||||||||||||||||||||||||||||RELATED TO CATEGORY CLASS||||||||||||||||||||||||||||||||||||||||||||||
	
	@Transactional
	public Category findCategory(String name) {
		return this.budgetDao.findCategory(name);
	}
	
	@Transactional
	public Category saveCategory(Category category) {
		return this.budgetDao.saveCategory(category);
	}

}
