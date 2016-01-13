package com.backend.gatewayservice.communication.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.domain.model.Customer;
import com.backend.domain.model.type.CommunicationEventType;
import com.backend.gatewayservice.EmailService;
import com.backend.gatewayservice.communication.handler.CommunicationHandler;

@Component
public class CommunicationHandlerImpl implements CommunicationHandler {

	@Autowired
	EmailService emailService;
	
	@Override
	public <T> Boolean processCommunicationEvent(
			CommunicationEventType communicationEventType, T object) {
		
		
		if (communicationEventType.getCode() == 1) {
			Customer customer = (Customer) object;
			emailService.sendSignupConfirmationEmail(customer.getFirstName(), customer.getEmail());
		}
		return null;
	}
	
}