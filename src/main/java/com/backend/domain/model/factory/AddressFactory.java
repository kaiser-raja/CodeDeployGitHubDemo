package com.backend.domain.model.factory;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.Address;

import com.backend.domain.model.exception.FactoryException;

@Component
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class AddressFactory extends BaseFactory {
	public synchronized Address create(String street, String area, String city) throws FactoryException {
		
		Address address = new Address();
		address.setStreet(street);
		address.setArea(area);
		address.setCity(city);
		return address;
	}
}
