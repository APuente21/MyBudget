package com.budget;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.budget.BudgetEntry;
import com.budget.User;

@Transactional 
@Repository("budgetDao")
public class BudgetDaoImp implements BudgetDao {
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<BudgetEntry> findAllEntries() {
		return sessionFactory.getCurrentSession().createQuery("from  BudgetEntry b").list();
	}
	
	@SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public User findUser(String email, String password) {
		return (User) sessionFactory.getCurrentSession()
                .getNamedQuery("User.findUser")
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<BudgetEntry> findEntriesByUser(long id) {
		return sessionFactory.getCurrentSession()
                .getNamedQuery("BudgetEntry.findEntriesByUser")
                .setParameter("id", id)
                .list();
	}
	
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /*This annotation says that we should insert an instance of SessionFactory, by referring
     *to the bean sessionFactory in the app-context-annotation.xml file     
    */
    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
