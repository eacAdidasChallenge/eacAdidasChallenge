package com.adidas.challenge.mailer.services;

import com.adidas.challenge.mailer.domain.MailerRequest;
import java.io.UnsupportedEncodingException;

public interface MailerService {
	
	void sendEmail(MailerRequest mailerRequest) throws UnsupportedEncodingException, InterruptedException;
}
