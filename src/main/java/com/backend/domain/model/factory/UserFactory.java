package com.backend.domain.model.factory;

import java.util.Date;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.domain.model.User;
import com.backend.domain.model.exception.FactoryException;
import com.backend.domain.model.type.UserStatusType;

@Component
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserFactory extends BaseFactory {
	public synchronized User create(String userName, String password, String firstName, String middleInitial, String lastName, String title,
			String company, String streetAddress, String city, String country, String state, String zipCode,
			String phoneNumber, String cellNumber, String alternatePhoneNumber, String fax, String email, 
			String projectDetails, Integer typeId) throws FactoryException {
		
		User user = new User(); 
		
		user.setUserName(userName);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setMiddleInitial(middleInitial);
		user.setLastName(lastName);
		user.setTitle(title);
		user.setCompany(company);
		user.setStreetAddress(streetAddress);
		user.setCity(city);
		user.setCountry(country);
		user.setState(state);
		user.setZipCode(zipCode);
		user.setPhoneNumber(phoneNumber);
		user.setCellNumber(cellNumber);
		user.setAlternatePhoneNumber(alternatePhoneNumber);
		user.setFax(fax);
		user.setEmail(email);
		user.setProjectDetails(projectDetails);
		user.setTypeId(typeId);
		user.setTechUpdates(0);
		user.setCreatedBy("SELF");
		user.setCreationDate(new Date());
		user.setProjectUpdates(0);
		user.setStatus(UserStatusType.values()[7].toString());
		return user;
	}
}
