package com.backend.domain.model.repository;


import org.springframework.data.repository.CrudRepository;

import com.backend.domain.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	Country findCountryByName(String name);
}
