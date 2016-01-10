/*package com.backend.application.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.application.service.CustomerService;
import com.backend.domain.model.Address;
import com.backend.domain.model.Customer;
import com.backend.domain.model.Phone;
import com.backend.domain.model.exception.FactoryException;
import com.backend.domain.model.exception.ServiceException;
import com.backend.domain.model.factory.AddressFactory;
import com.backend.domain.model.factory.CustomerFactory;
import com.backend.domain.model.factory.PhoneFactory;
import com.backend.domain.model.repository.CustomerRepository;
import com.backend.domain.model.type.CommunicationEventType;
import com.backend.gatewayservice.communication.handler.CommunicationHandler;
import com.backend.kernel.StringUtility;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerFactory customerFactory;
	
	@Autowired
	AddressFactory addressFactory;
	
	@Autowired
	PhoneFactory phoneFactory;
	
	@Autowired
	CommunicationHandler communicationHandler;
	
	@Override
	public Customer signup(String firstName, String lastName, String password, String email,
			String countryCode, String phoneNumber, String street, String area,
			String city) throws ServiceException {
		
		Customer customer = add(firstName, lastName, password, email, countryCode, phoneNumber, street, area, city);
		return customer;
	}
	
	
	private Customer add(String firstName, String lastName, String password, String email,
			String countryCode, String phoneNumber, String street, String area, String city) throws ServiceException {
		
		Customer customer =  new Customer();
		try {
			Address address = addressFactory.create(street, area, city);
			Phone phone = phoneFactory.create(countryCode, phoneNumber);
			
			firstName = StringUtility.capitalize(firstName);
			lastName = StringUtility.capitalize(lastName);
			
			customer = customerFactory.create(firstName, lastName, BCrypt.hashpw(password, BCrypt.gensalt(12)), email, address, phone);
			customerRepository.save(customer);
			
			communicationHandler.processCommunicationEvent(CommunicationEventType.NEW_CUSTOMER_SIGNUP, customer);
			
			
		} catch (FactoryException e) {
			throw new ServiceException(e);
		}
		return customer;
		
	}

}
*/