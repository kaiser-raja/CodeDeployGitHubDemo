package com.backend.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "countries")

@NamedQueries({
	@NamedQuery(name = "findCountryByName", query = "select c.code from Country c where c.name = :name")
})
public class Country {
	private String code;
	private String name;
	
	

	@Column(name = "code", columnDefinition="CHAR")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Id
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
