package com.backend.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "phone")

@NamedQueries({
	@NamedQuery(name = "findPhoneByCountryCodeAndPhoneNumber", query = "select p from Phone p where p.countryCode = :countryCode AND p.phoneNumber = :phoneNumber"),
})

public class Phone extends BaseEntity {
	private String countryCode;
	private String phoneNumber;
	
	@OneToOne(mappedBy = "phone", cascade = CascadeType.PERSIST)
    private Customer customer;
	
	
	@Column(name = "country_code")
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Column(name = "phone_number", unique = true)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
