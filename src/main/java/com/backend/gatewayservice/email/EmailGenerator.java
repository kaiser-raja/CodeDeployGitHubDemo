package com.backend.gatewayservice.email;

import java.io.IOException;

import org.antlr.stringtemplate.StringTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.backend.kernel.FileUtility;
import com.backend.kernel.ServiceUtility;

import static com.backend.kernel.TemplateKey.NEW_CUSTOMER_FIRST_NAME;
import static com.backend.kernel.TemplateKey.SERVICE_NAME;
import static com.backend.kernel.TemplateKey.SERVICE_URL;

@Component
public class EmailGenerator {

	@Autowired
	ApplicationContext applicationContext;
	
	
	public String signupConfirmationEmail(String firstName, String email) throws IOException {

     	String fileName = "classpath:WEB-INF/email_templates/newCustomerSignupEmailTemplate.st";
        Resource resource = applicationContext.getResource(fileName);
        StringTemplate emailTemplate = new StringTemplate(FileUtility.readFileAsString(resource.getFile().getAbsolutePath()));
		emailTemplate.setAttribute(NEW_CUSTOMER_FIRST_NAME, firstName);
        emailTemplate.setAttribute(SERVICE_NAME, ServiceUtility.SERVICE_NAME);
        emailTemplate.setAttribute(SERVICE_URL, ServiceUtility.SERVICE_URL);
        return emailTemplate.toString();
	}
}
