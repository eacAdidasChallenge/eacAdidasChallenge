package com.adidas.challenge.subscription.domain;

import lombok.Data;


@Data
public class SubsRequest {

	private int id;
    private String email;
    private String firstName;
    private String gender;
    private String dateOfBith;
    private String consent;
    private String idNewsletter;
}