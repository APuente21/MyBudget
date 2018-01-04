package com.budget.domain;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
@NamedQuery(name="BudgetEntry.findEntriesByUser", 
query="select distinct b from BudgetEntry b left join fetch b.category c where b.user.id = :id")
})
@Table(name = "BUDGET_ENTRIES")
public class BudgetEntry {
	private long id;
	private long user_id;
	private User user;
	private Category category;
	private long amount;
	private Date date;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
	public Long getId() {
		return this.id;
	}
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user_id = user.getId();
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
    @Column(name = "AMOUNT")
	public long getAmount() {
		return this.amount;
	}
    
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Temporal(TemporalType.DATE)
    @Column(name = "ENTRY_DATE")
	public Date getDate() {
		return this.date;
	}
    
	public String toString() {
		return "Date: " + date + " Amount: " + amount + " User: " + user.getFirstName() + " " + user.getLastName() + 
				" Category: " + category.getName();
	}
}
