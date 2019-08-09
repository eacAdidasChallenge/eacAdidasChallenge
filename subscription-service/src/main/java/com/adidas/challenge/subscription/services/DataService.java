package com.adidas.challenge.subscription.services;

import com.adidas.challenge.subscription.domain.Subscription;
import com.adidas.challenge.subscription.domain.SubscriptionRequest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;
import java.text.SimpleDateFormat;

@Service
@Slf4j
public class DataService {

    @Autowired
    protected RestTemplate restTemplate;

    @Value("${subscriptionService.endpoint:http://SUBSCRIPTION-DATA-SERVICE}")
    private String SUBSCRIPTION_SERVICE_URL;

    @Value("${subscriptionData.endpoint:/add}")
    private String SUBSCRIPTION_ENDPOINT;

    @HystrixCommand(fallbackMethod = "subscriptionDefault")
    public String addSubscription(SubscriptionRequest subscriptionRequest) {    	
	   String requestURI=SUBSCRIPTION_SERVICE_URL + SUBSCRIPTION_ENDPOINT;
	   
	   UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(requestURI)
   	        .queryParam("email", subscriptionRequest.getEmail())
   	        .queryParam("firstName", subscriptionRequest.getFirstName())
   	     	.queryParam("gender", subscriptionRequest.getGender())
		   	.queryParam("dateOfBith", new SimpleDateFormat("yyyy-MM-dd").format(subscriptionRequest.getDateOfBith()))
		   	.queryParam("consent", ""+subscriptionRequest.getConsent())
		   	.queryParam("idNewsletter", ""+subscriptionRequest.getIdNewsletter());
    	
        ResponseEntity<String> response = restTemplate.exchange(
        		builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>(){});
        return response.getBody();
    }


    public String subscriptionDefault(SubscriptionRequest subscriptionRequest) {
        log.error("Subscription Data Service is unavailable now.");
        return "";
    }
}