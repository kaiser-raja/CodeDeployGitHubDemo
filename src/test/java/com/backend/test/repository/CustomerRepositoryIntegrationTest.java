
package com.backend.test.repository;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.backend.application.config.ApplicationConfig;
import com.backend.domain.model.Customer;
import com.backend.domain.model.repository.CustomerRepository;




@ContextConfiguration(classes = ApplicationConfig.class)
public class CustomerRepositoryIntegrationTest extends AbstractIntegrationTest{

	@Autowired
	CustomerRepository repository;

	@Test
	public void savesCustomerCorrectly() {
		Customer cust = new Customer();
    	//cust.setAddress(null);
    	cust.setCurrency("PKR");
    	cust.setEmail("rubbish@rubbish.com");
    	cust.setFirstName("john");
    	cust.setId(2);
    	cust.setLastName("smith");
    	cust.setPassword("gabardash");
    	//cust.setPhone(null);
    	
    	repository.save(cust);
		Customer result = repository.save(cust);
		//assertThat(result.getId(), is(notNullValue()));
	}
}
