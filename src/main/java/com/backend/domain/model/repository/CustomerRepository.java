package com.backend.domain.model.repository;


import org.springframework.data.repository.CrudRepository;

import com.backend.domain.model.Customer;
import com.backend.domain.model.Phone;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@SuppressWarnings("unchecked")
	Customer save(Customer customer); 
	public Customer findByEmail(String email);
	Customer findByPhone(Phone phone);
}
