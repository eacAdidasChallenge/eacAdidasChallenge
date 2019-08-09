package com.adidas.challenge.mailer.domain;

import lombok.Data;


@Data
public class MailerRequest {

	private int id;
    private String email;
    private String firstName;
    private String gender;
    private String dateOfBith;
    private String consent;
    private String idNewsletter;
}