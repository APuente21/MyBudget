package com.budget.dao;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.budget.domain.BudgetEntry;
import com.budget.domain.Category;
import com.budget.domain.Phone;
import com.budget.domain.User;

@Repository
public class BudgetDaoImp implements BudgetDao {
	private SessionFactory sessionFactory;
	
	//|||||||||||||||||||||||||||||||||||||||RELATED TO USER CLASS||||||||||||||||||||||||||||||||||||||||||||||
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
		return list;
	}
	
    @Transactional
    public User saveUser(User user) {
    	sessionFactory.getCurrentSession().saveOrUpdate(user);
    	return user;
    }
	
	public User findUserByNumber(Phone number) {
		return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findUserByNumber")
                .setParameter("number", number)
                .uniqueResult();
	}
	
	public User findUser(String email, String password) {
		return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findUser")
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
	}
	
	//|||||||||||||||||||||||||||||||||||||||RELATED TO BUDGET ENTRY CLASS||||||||||||||||||||||||||||||||||||||||||||||
	
    @SuppressWarnings("unchecked")
	public List<BudgetEntry> findEntriesByUser(long id) {
		return sessionFactory.getCurrentSession()
                .getNamedQuery("BudgetEntry.findEntriesByUser")
                .setParameter("id", id)
                .list();
	}
    
	@SuppressWarnings("unchecked")
	public List<BudgetEntry> findAllEntries() {
		return sessionFactory.getCurrentSession().createQuery("from BudgetEntry b").list();
	}
	
    @Transactional
    public BudgetEntry saveBudgetEntry(BudgetEntry bEntry) {
    	sessionFactory.getCurrentSession().saveOrUpdate(bEntry);
    	return bEntry;
    }
    
	//|||||||||||||||||||||||||||||||||||||||RELATED TO PHONE CLASS||||||||||||||||||||||||||||||||||||||||||||||
	
    @Transactional
    public Phone savePhone(Phone phone) {
    	sessionFactory.getCurrentSession().saveOrUpdate(phone);
    	return phone;
    }
    
    @SuppressWarnings("unchecked")
	public Phone findPhone(String countryCode, String areaCode, String number) {
		return (Phone) sessionFactory.getCurrentSession()
                .getNamedQuery("Phone.findPhone")
                .setParameter("countryCode", countryCode)
                .setParameter("areaCode", areaCode)
                .setParameter("number", number)
                .uniqueResult();
	}
    
  //|||||||||||||||||||||||||||||||||||||||RELATED TO CATEGORY CLASS||||||||||||||||||||||||||||||||||||||||||||||
    
    @SuppressWarnings("unchecked")
    public Category findCategory(String name) {
    	return (Category) sessionFactory.getCurrentSession()
    			.getNamedQuery("Category.findCategory")
    			.setParameter("name", name)
    			.uniqueResult();
    }
    
    @Transactional
    public Category saveCategory(Category category) {
    	sessionFactory.getCurrentSession().saveOrUpdate(category);
    	return category;
    }
    
  //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
