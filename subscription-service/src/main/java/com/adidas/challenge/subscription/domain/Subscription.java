package com.adidas.challenge.subscription.domain;

import lombok.Data;
import java.util.Date;

@Data
public class Subscription {

    private int id;
    private String email;
    private String firstName;
    private String gender;
    private Date dateOfBith;
    private Boolean consent;
    private Integer idNewsletter;
}