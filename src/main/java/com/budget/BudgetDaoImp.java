package com.budget;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.budget.BudgetEntry;
import com.budget.User;

@Repository
public class BudgetDaoImp implements BudgetDao {
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<BudgetEntry> findAllEntries() {
		return sessionFactory.getCurrentSession().createQuery("from BudgetEntry b").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
		return list;
	}
	
    @Override
	public User findUser(String email, String password) {
		return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findUser")
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
	}
	
    @SuppressWarnings("unchecked")
	@Override
	public List<BudgetEntry> findEntriesByUser(long id) {
		return sessionFactory.getCurrentSession()
                .getNamedQuery("BudgetEntry.findEntriesByUser")
                .setParameter("id", id)
                .list();
	}
    
    @Transactional
    @Override
    public User saveUser(User user) {
    	sessionFactory.getCurrentSession().saveOrUpdate(user);
    	return user;
    }
	
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /*This annotation says that we should insert an instance of SessionFactory, by referring
     *to the bean sessionFactory in the app-context-annotation.xml file     
    */

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
