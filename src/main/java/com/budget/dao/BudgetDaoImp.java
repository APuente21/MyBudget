package com.budget.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.budget.domain.BudgetEntry;

@Transactional 
@Repository("budgetDao")
public class BudgetDaoImp implements BudgetDao {
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<BudgetEntry> findAllEntries() {
		List<BudgetEntry> test = sessionFactory.getCurrentSession().createQuery("from  BudgetEntry b").list();
		return test;
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
