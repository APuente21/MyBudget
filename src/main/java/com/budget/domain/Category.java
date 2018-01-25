package com.budget.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category {
	private long id;
	private String name;
	private Set<BudgetEntry> entry = new HashSet<BudgetEntry>();
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    @Column(name = "NAME")
	public String getName() {
		return this.name;
	}
    
	 @OneToMany(mappedBy = "category", cascade=CascadeType.ALL,
			 orphanRemoval= true)
	 public Set<BudgetEntry> getBudgetEntry(){
		 return this.entry;
	 }
	 
	 public void setBudgetEntry(Set<BudgetEntry> entry) {
		 this.entry = entry;
	 }
    
    public String toString() {
    	return "Category: " + name;
    }
}
