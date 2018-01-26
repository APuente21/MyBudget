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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@NamedQueries({
@NamedQuery(name="User.findUser", 
query="select u from User u where u.email = :email and u.password = :password")
})
@Table(name = "USERS")
public class User {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String number;
	private Set<BudgetEntry> entry = new HashSet<BudgetEntry>();
	
	public User(){	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
	public Long getId() {
		return this.id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
    @Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}
    
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    @Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}
	
    @Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}
    
	public void setPassword(String password) {
		this.password = password;
	}
	
    @Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}
	
	 @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,
			 orphanRemoval= true)
	 public Set<BudgetEntry> getBudgetEntry(){
		 return this.entry;
	 }
	 
	 public void setBudgetEntry(Set<BudgetEntry> entry) {
		 this.entry = entry;
	 }
	
	public void setNumber(String number) {
		this.number = number;
	}
	 
    @Column(name = "PHONE_NUMBER")
	public String getNumber() {
		return this.number;
	}
    
    public String toString() {
    	return "First Name: " + firstName + " Last Name: " + lastName + " Phone #: " + number;
    }
	
}
