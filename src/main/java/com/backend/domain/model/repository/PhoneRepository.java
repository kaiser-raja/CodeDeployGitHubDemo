package com.backend.domain.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.domain.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
	public Phone findByCountryCodeAndPhoneNumber(String countryCode, String phoneNumber);

}
