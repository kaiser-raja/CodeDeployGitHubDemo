package com.backend.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "customer")
@NamedQueries({
	@NamedQuery(name = "findCustomerByEmail", query = "select c from Customer c where lower(c.email) = :email"),
	@NamedQuery(name = "findCustomerByPhone", query = "select c from Customer c, Phone p where c .phone.id = p.id AND p.countryCode = :countryCode AND p.phoneNumber = :phoneNumber"),
})

public class Customer extends BaseEntity {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String currency;
	private List<Address> addresses;
	private Phone phone;
	
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true/*, fetch = FetchType.LAZY, mappedBy="customer"*/)
	@JoinColumn(name="customer_id")
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	/*public void setCustomerAddress(Address address) {
		if (addresses == null) {
			addresses = new ArrayList<Address>();
		}
		address.setCustomer(this);
		addresses.add(address);
	}*/
}
