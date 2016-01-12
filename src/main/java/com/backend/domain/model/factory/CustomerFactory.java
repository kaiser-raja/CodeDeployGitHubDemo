package com.backend.domain.model.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.Address;
import com.backend.domain.model.Customer;
import com.backend.domain.model.Phone;
import com.backend.domain.model.exception.FactoryException;

@Component
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class CustomerFactory extends BaseFactory {
	public synchronized Customer create(String firstName, String lastName, String password, String email, 
			Address address, Phone phone) throws FactoryException {
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		Customer customer = new Customer(); 
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPassword(password);
		customer.setEmail(email);
		customer.setAddresses(addresses);
		customer.setPhone(phone);
		return customer;
	}
}
