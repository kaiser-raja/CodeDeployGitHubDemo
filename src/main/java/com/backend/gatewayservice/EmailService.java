package com.backend.gatewayservice;

public interface EmailService {
	void sendSignupConfirmationEmail(String firstName, String email);
}
