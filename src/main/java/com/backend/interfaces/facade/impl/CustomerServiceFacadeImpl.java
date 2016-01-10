/*package com.backend.interfaces.facade.impl;

import java.util.HashMap;
import java.util.Map;



import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.application.service.CustomerService;
import com.backend.domain.model.Phone;
import com.backend.domain.model.exception.DomainException;
import com.backend.domain.model.exception.FacadeException;
import com.backend.domain.model.factory.PhoneFactory;
import com.backend.domain.model.repository.CustomerRepository;
import com.backend.interfaces.facade.CustomerServiceFacade;
import com.backend.interfaces.json.model.CustomerModel;
import com.backend.interfaces.json.model.CustomerSignupModel;
import com.backend.kernel.StringUtility;


@Component
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class CustomerServiceFacadeImpl extends BaseServiceFacadeImpl implements CustomerServiceFacade {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	PhoneFactory phoneFactory;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public CustomerModel signup(CustomerSignupModel customerSignupModel)
			throws FacadeException {
		try {
			if (customerSignupModel.getPhoneCountryCode().isEmpty()) {
                throw new FacadeException("Country code cannot be empty");
            }
			
            if (customerSignupModel.getPhoneNumber().isEmpty()) {
                throw new FacadeException("Phone number cannot be empty");
            }
            
            if (customerSignupModel.getEmail().isEmpty()) {
                throw new FacadeException("Email cannot be empty");
            }

            if(!StringUtility.isDigitsOnly(customerSignupModel.getPhoneNumber())) {
            	throw new FacadeException("Enter digits only for phone number");
            }
            
            Phone phone = phoneFactory.create(customerSignupModel.getPhoneCountryCode(), customerSignupModel.getPhoneNumber());
            phone.setId(-2);
            if(customerRepository.findByPhone(phone) != null) {
            	throw new FacadeException("Signup unsuccessful. Phone number " + phone.getPhoneNumber() + " already exists");
            }
            else {
            	Customer cust = customerRepository.findByPhone(phone);
            	System.out.println(cust.getFirstName());
            }



            CustomerModel customerModel = null;
            customerModel = mapObject(customerService.signup(customerSignupModel.getFirstName(), customerSignupModel.getLastName(),
            		customerSignupModel.getPassword(), customerSignupModel.getEmail(), customerSignupModel.getPhoneCountryCode(),
            		customerSignupModel.getPhoneNumber(), customerSignupModel.getStreet(), customerSignupModel.getArea(), customerSignupModel.getCity()), CustomerModel.class, createCustomFieldMapping());

            return customerModel;

        } catch (ServiceException e) {
            throw new FacadeException(e);
        } catch (DomainException e) {
            throw new FacadeException(e);
        }
	}
	
	private Map<String, String> createCustomFieldMapping() {
        Map<String, String> customFieldMapping = new HashMap<String, String>();
        customFieldMapping.put("id", "customerId"); 
        
        return customFieldMapping;
	}
}
*/