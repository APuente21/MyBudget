package com.budget.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@NamedQueries({
@NamedQuery(name="Phone.findPhone", 
query="select p from Phone p where p.countryCode = :countryCode AND p.areaCode = :areaCode AND "
		+ "p.number = :number")
})
@Table(name = "PHONES")
public class Phone {
	private String countryCode;
	private String areaCode;
	private String number;
	private long id;
	
	public Phone() {}
	
	public Phone(String cCode, String aCode, String pNum) {
		this.countryCode = cCode;
		this.areaCode = aCode;
		this.number = pNum;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCountryCode(String input) {
		this.countryCode = input;
	}
	
	public void setAreaCode(String input) {
		this.areaCode = input;
	}
	
	public void setNumber(String input) {
		this.number = input;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
	public Long getId() {
		return this.id;
	}
	
	@Column(name = "COUNTRY_CODE")
	public String getCountryCode() {
		return this.countryCode;
	}
	
	@Column(name = "AREA_CODE")
	public String getAreaCode() {
		return  this.areaCode;
	}
	
	@Column(name = "NUMBER")
	public String getNumber() {
		return this.number;
	}
	
	public static String [] getDigits(String input) {
		String[] digits = new String[3];
			digits[0] = input.substring(1, input.length()-10);
			digits[1] = input.substring(input.length()-10, input.length()-7);
			digits[2] = input.substring(input.length()-7);
		return digits;
	}
	  

	public String toString() {
		return ("+" + countryCode + areaCode + number);
	}
}
