package com.backend.domain.model.factory;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.Phone;
import com.backend.domain.model.exception.FactoryException;

@Component
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class PhoneFactory extends BaseFactory {
	public synchronized Phone create(String countryCode, String phoneNumber) throws FactoryException {
		
		Phone phone = new Phone();
		phone.setCountryCode(countryCode);
		phone.setPhoneNumber(phoneNumber);
		return phone;
	}
}
