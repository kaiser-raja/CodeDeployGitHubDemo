/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 
package com.backend.test.repository;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.backend.application.config.ApplicationConfig;
import com.backend.domain.model.Customer;
import com.backend.domain.model.repository.CustomerRepository;


*//**
 * Integration tests for {@link CustomerRepository}.
 * 
 * @author Oliver Gierke
 *//*

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
*/