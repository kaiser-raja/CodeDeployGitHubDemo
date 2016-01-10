package com.backend.interfaces.facade.impl;

import java.util.HashMap;
import java.util.Map;



import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.application.service.UserService;
import com.backend.domain.model.User;
import com.backend.domain.model.UserType;
import com.backend.domain.model.exception.DomainException;
import com.backend.domain.model.exception.FacadeException;
import com.backend.domain.model.repository.CountryRepository;
import com.backend.domain.model.repository.UserRepository;
import com.backend.domain.model.repository.UserTypeRepository;
import com.backend.interfaces.facade.UserServiceFacade;
import com.backend.interfaces.json.model.UserModel;
import com.backend.interfaces.json.model.UserRegistrationModel;


@Component
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class UserServiceFacadeImpl extends BaseServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public UserModel register(UserRegistrationModel userRegistrationModel, String userType) throws FacadeException {
		try {
			Integer typeId = null;
			UserType type = userTypeRepository.findIdByName(userType);
			if (type == null) {
				throw new FacadeException("Invalid user type");
			}
			else {
				typeId = type.getId();
			}
			
			User user = userRepository.findByUserName(userRegistrationModel.getUserName());
			if (user != null && userRegistrationModel.getUserName().equals(user.getUserName())) {
				throw new FacadeException("Username already exists");
			}
			
            UserModel userModel = null;
            userModel = mapObject(userService.register(userRegistrationModel.getUserName(), userRegistrationModel.getPassword(), userRegistrationModel.getFirstName(), 
            		userRegistrationModel.getMiddleInitial(), userRegistrationModel.getLastName(), userRegistrationModel.getTitle(), userRegistrationModel.getCompany(), 
            		userRegistrationModel.getStreetAddress(), userRegistrationModel.getCity(), userRegistrationModel.getCountry(), userRegistrationModel.getState(), 
            		userRegistrationModel.getZipCode(), userRegistrationModel.getPhoneNumber(), userRegistrationModel.getCellNumber(), userRegistrationModel.getAlternatePhoneNumber(), 
            		userRegistrationModel.getFax(), userRegistrationModel.getEmail(), userRegistrationModel.getProjectDetails(), typeId), UserModel.class, createCustomFieldMapping());

            return userModel;

        } catch (ServiceException e) {
            throw new FacadeException(e);
        } catch (DomainException e) {
            throw new FacadeException(e);
        }
	}
	
	private Map<String, String> createCustomFieldMapping() {
        Map<String, String> customFieldMapping = new HashMap<String, String>();
        customFieldMapping.put("id", "userId"); 
        
        return customFieldMapping;
	}
	
}
