package com.backend.gatewayservice.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.backend.gatewayservice.EmailService;
import com.backend.gatewayservice.email.EmailGenerator;
import com.backend.kernel.CredentialsUtility;

@Component
public class EmailServiceImpl implements EmailService {
	
	 private static final String CHARSET_UTF_8 = "UTF-8";
	 private static final String CONTENT_TYPE = "text/html";

	 @Autowired
	 EmailGenerator emailGenerator;
	    
	@Override
	@Async
	public void sendSignupConfirmationEmail(String firstName, String email) {
		try {
			String emailContent = emailGenerator.signupConfirmationEmail(firstName, email);
			String from = "outofline1083@gmail.com";
			List<String> to = new ArrayList<String>();
			to.add(email);
			
			String subject = firstName + ", Welcome to Foodies";
			
			sendThroughAmazonGateway(from, to, subject, emailContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendThroughAmazonGateway(String from, List<String> to, String subject, String emailContent) {
		try {
			Session session = Session.getInstance(new Properties());
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setSubject(subject, CHARSET_UTF_8);
			mimeMessage.setText(emailContent, CHARSET_UTF_8);
            mimeMessage.addHeader("Content-Type", CONTENT_TYPE);
            
            // FROM
            mimeMessage.setFrom(new InternetAddress(from));

            // TO
            InternetAddress[] toAddresses = new InternetAddress[to.size()];
            for (int i = 0; i < to.size(); i++) {
                toAddresses[i] = new InternetAddress(to.get(i));
            }
            
            mimeMessage.setRecipients(Message.RecipientType.TO, toAddresses);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            mimeMessage.writeTo(outputStream);
            RawMessage rawMessage = new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));

            SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest(rawMessage);

         // Set AWS access credentials
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(new BasicAWSCredentials(
                    CredentialsUtility.AMAZON_ACCESS_KEY, CredentialsUtility.AMAZON_SECRET_KEY));
            
            Region region = Region.getRegion(Regions.US_WEST_2);
            client.setRegion(region);
            // Call Amazon SES to send the message
            client.sendRawEmail(rawEmailRequest);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
