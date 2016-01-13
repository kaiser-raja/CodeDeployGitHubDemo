package com.backend.test.applicationConfig;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.application.config.ApplicationConfig;
import com.backend.domain.model.repository.CustomerRepository;
import com.backend.interfaces.facade.CustomerServiceFacade;


public class ApplicationConfigTest {

	@Test
	public void bootstrapAppFromJavaConfig() {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		assertThat(context, is(notNullValue()));
		assertThat(context.getBean(CustomerRepository.class), is(notNullValue()));
		assertThat(context.getBean(CustomerServiceFacade.class), is(notNullValue()));
	}

}
