package com.backend.application.service;


import com.backend.domain.model.Customer;
import com.backend.domain.model.exception.ServiceException;


public interface CustomerService {
	Customer signup(String firstName, String lastName, String password, String email, String countryCode, 
			String phoneNumber, String street, String area, String city) throws ServiceException;
}
