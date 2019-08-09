package com.adidas.challenge.mailer.services;

import com.adidas.challenge.mailer.domain.MailerRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import java.io.UnsupportedEncodingException;

import java.util.List;

@Service
@Slf4j
@EnableEmailTools
public class MailerServiceImpl implements MailerService {
	
	@Autowired
	private PlainMailSender pmMailer;
	
	@Override
	public void sendEmail(MailerRequest mailerRequest) throws UnsupportedEncodingException, InterruptedException {
		pmMailer.send(mailerRequest);
	}
	
}