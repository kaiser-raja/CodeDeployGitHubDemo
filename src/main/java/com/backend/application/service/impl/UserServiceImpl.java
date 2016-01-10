package com.backend.application.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.application.service.UserService;
import com.backend.domain.model.User;
import com.backend.domain.model.exception.FactoryException;
import com.backend.domain.model.exception.ServiceException;
import com.backend.domain.model.factory.UserFactory;
import com.backend.domain.model.repository.CountryRepository;
import com.backend.domain.model.repository.UserRepository;
import com.backend.kernel.StringUtility;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserFactory userFactory;
	
	@Autowired
	CountryRepository countryRepository;
	
	
	@Override
	public User register(String userName, String password, String firstName, String middleInitial, String lastName,
			String title, String company, String streetAddress, String city, String country, String state,
			String zipCode, String phoneNumber, String cellNumber, String alternatePhoneNumber, String fax,
			String email, String projectDetails, Integer typeId) throws ServiceException {
		
		
		User user = add(userName,  password,  firstName,  middleInitial,  lastName,
				 title,  company,  streetAddress,  city,  country,  state,
				 zipCode,  phoneNumber,  cellNumber,  alternatePhoneNumber,  fax,
				 email,  projectDetails, typeId);
		return user;
	}
	
	
	private User add(String userName, String password, String firstName, String middleInitial, String lastName,
			String title, String company, String streetAddress, String city, String country, String state,
			String zipCode, String phoneNumber, String cellNumber, String alternatePhoneNumber, String fax,
			String email, String projectDetails, Integer typeId) throws ServiceException {
		
		User user =  new User();
		try {
			firstName = StringUtility.capitalize(firstName);
			lastName = StringUtility.capitalize(lastName);
			middleInitial = StringUtility.capitalize(middleInitial);
			
			country = countryRepository.findCountryByName(country).getCode();
			
			user = userFactory.create( userName,  BCrypt.hashpw(password, BCrypt.gensalt(12)),  firstName,  middleInitial,  lastName,
					 title,  company,  streetAddress,  city,  country,  state,
					 zipCode,  phoneNumber,  cellNumber,  alternatePhoneNumber,  fax,
					 email,  projectDetails, typeId);
			userRepository.save(user);
						
			
		} catch (FactoryException e) {
			throw new ServiceException(e);
		}
		return user;
		
	}


	

}
