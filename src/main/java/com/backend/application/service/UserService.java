package com.backend.application.service;


import com.backend.domain.model.User;
import com.backend.domain.model.exception.ServiceException;


public interface UserService {
	User register(String userName, String password, String firstName, String middleInitial, String lastName, String title,
			String company, String streetAddress, String city, String country, String state, String zipCode,
			String phoneNumber, String cellNumber, String alternatePhoneNumber, String fax, String email, 
			String projectDetails, Integer typeId) throws ServiceException;
}
