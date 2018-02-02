package com.budget.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="Category.findCategory", 
query="select c from Category c where c.name = :name")
})
@Table(name = "CATEGORIES")
public class Category {
	private long id;
	private String name;	
	

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
    
    public boolean equals(Category input) {
    	return name.toLowerCase().equals(input.getName().toLowerCase());
    }
    
    
    public String toString() {
    	return "Category: " + name;
    }
}
