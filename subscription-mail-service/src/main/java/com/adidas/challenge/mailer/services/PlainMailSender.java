package com.adidas.challenge.mailer.services;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.challenge.mailer.domain.MailerRequest;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class PlainMailSender {

    @Autowired
    private EmailService emailService;

    public void send(MailerRequest mailerRequest) throws UnsupportedEncodingException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress("eacadidaschallenge@gmail.com", "EAC AdidasChallenge"))
                .to(newArrayList(new InternetAddress(mailerRequest.getEmail(), "Overseer Challenge")))
                .subject("EAC :: Subscription success")
                .body("Welcome :: Subscription to newsletter "+mailerRequest.getIdNewsletter()+" success! (adidas challenge - "+mailerRequest.getDateOfBith()+")")
                .encoding("UTF-8").build();

        emailService.send(email);
    }
}
