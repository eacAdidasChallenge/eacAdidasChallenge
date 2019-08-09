package com.adidas.challenge.subscription.services;

import com.adidas.challenge.subscription.domain.Subscription;
import com.adidas.challenge.subscription.domain.SubscriptionRequest;
import com.adidas.challenge.subscription.domain.response.SubscriptionResponse;

import com.adidas.challenge.subscription.services.SubsMailService;
import com.adidas.challenge.subscription.domain.SubsRequest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@Slf4j
public class SubscriptionService {

    @Autowired
    private DataService dataService;
    
    @Autowired
    private SubsMailService subsMailService;

    public SubscriptionResponse operateWithIdReturn(SubscriptionRequest subscriptionRequest) {
        String subscriptionId = dataService.addSubscription(subscriptionRequest);

        SubsRequest subsRequest = new SubsRequest();
        	subsRequest.setEmail(subscriptionRequest.getEmail());
        	subsRequest.setFirstName(subscriptionRequest.getFirstName());
        	subsRequest.setGender(subscriptionRequest.getGender());
        	subsRequest.setDateOfBith(new SimpleDateFormat("yyyy-MM-dd").format(subscriptionRequest.getDateOfBith()));
        	subsRequest.setConsent(""+subscriptionRequest.getConsent());
        	subsRequest.setIdNewsletter(""+subscriptionRequest.getIdNewsletter());
        subsMailService.sendAnEmail(subsRequest);
        
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setId(subscriptionId);
        return subscriptionResponse;
    }
}
