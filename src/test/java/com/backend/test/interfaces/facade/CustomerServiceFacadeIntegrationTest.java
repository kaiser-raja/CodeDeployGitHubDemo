package com.backend.test.interfaces.facade;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.backend.application.config.ApplicationConfig;
import com.backend.domain.model.exception.FacadeException;
import com.backend.interfaces.facade.CustomerServiceFacade;
import com.backend.interfaces.json.model.CustomerSignupModel;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class CustomerServiceFacadeIntegrationTest {
	
	@Autowired
	CustomerServiceFacade customerServiceFacade;

	@Test
	public void savesCustomerCorrectly() {
		CustomerSignupModel c = new CustomerSignupModel();
		c.setArea("DDDD");
		c.setFirstName("Kaiser");
		c.setLastName("raja");
		c.setPhoneCountryCode("92");
		c.setPhoneNumber("3222495691");
		try {
			customerServiceFacade.signup(c);
		} catch (FacadeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
