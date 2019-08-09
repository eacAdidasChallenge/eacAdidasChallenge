package com.adidas.challenge.subscription.services;

import com.adidas.challenge.subscription.domain.SubsRequest;

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
public class SubsMailService {

    @Autowired
    protected RestTemplate restTemplate;

    @Value("${mailService.endpoint:http://SUBSCRIPTION-MAIL-SERVICE}")
    private String MAIL_SERVICE_URL;

    @Value("${mailData.endpoint:/send}")
    private String MAIL_ENDPOINT;

    @HystrixCommand(fallbackMethod = "subscriptionDefault")
    public String sendAnEmail(SubsRequest subsRequest) {    	
	   String requestURI=MAIL_SERVICE_URL + MAIL_ENDPOINT;
	   log.info("Data for mailing received: " + subsRequest.getEmail() +" "+ subsRequest.getFirstName() +" "+ subsRequest.getGender()
	   		+" "+ subsRequest.getDateOfBith() +" "+ subsRequest.getConsent() +" "+ subsRequest.getIdNewsletter());
	   UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(requestURI)
   	        .queryParam("email", subsRequest.getEmail())
   	        .queryParam("firstName", subsRequest.getFirstName())
   	     	.queryParam("gender", subsRequest.getGender())
		   	.queryParam("dateOfBith", subsRequest.getDateOfBith())
		   	.queryParam("consent", subsRequest.getConsent())
		   	.queryParam("idNewsletter", subsRequest.getIdNewsletter());
    	
        ResponseEntity<String> response = restTemplate.exchange(
        		builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>(){});
        return response.getBody();
    }

    public String subscriptionDefault(SubsRequest subsRequest) {
        log.error("Subscription Data Service is unavailable now.");
        return "";
    }
}