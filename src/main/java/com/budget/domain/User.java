package com.budget.domain;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQueries({
@NamedQuery(name="User.findUser", 
query="select u from User u where u.email = :email and u.password = :password"),
@NamedQuery(name="User.findUserByNumber", 
query="select u from User u where u.number = :number"),
@NamedQuery(name="User.findUserById", 
query="select u from User u where u.id = :id")
})
@Table(name = "USERS")
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Set<BudgetEntry> entry = new HashSet<BudgetEntry>();
	private Phone number;
	
	public User(){	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
	public int getId() {
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
	 	 
	public void setNumber(Phone number) {
		this.number = number;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PHONE_ID")
	public Phone getNumber() {
		return this.number;
	}
    
    public String toString() {
    	return "First Name: " + firstName + " Last Name: " + lastName + " Phone #: " + number;
    }
	
}
