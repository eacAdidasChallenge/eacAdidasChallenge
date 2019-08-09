package com.adidas.challenge.subscription.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SubscriptionRequest {

	@NotNull
    private String email;
    
    private String firstName;
    
    private String gender;
    
    @NotNull
    private Date dateOfBith;
    
    @NotNull
    private Boolean consent;
    
    @NotNull
    private Integer idNewsletter;
}