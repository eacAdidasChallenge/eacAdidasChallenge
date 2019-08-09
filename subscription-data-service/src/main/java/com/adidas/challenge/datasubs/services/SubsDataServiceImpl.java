package com.adidas.challenge.datasubs.services;

import com.adidas.challenge.datasubs.domain.Subs;
import com.adidas.challenge.datasubs.repositories.SubsDataRepository;
import com.adidas.challenge.datasubs.domain.SubsRequest;

import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubsDataServiceImpl implements SubsDataService {
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

    @Autowired
    private SubsDataRepository subsDataRepository;
	
	@Override
    public String addSubs (SubsRequest subsRequest) {
		int id = 0;
		try {
			Subs newSubscription = new Subs(subsRequest.getEmail(),subsRequest.getFirstName(),
					subsRequest.getGender(),subsRequest.getDateOfBith(),subsRequest.getConsent(), subsRequest.getIdNewsletter());		
		
			newSubscription = subsDataRepository.save(newSubscription);
			id = newSubscription.getId();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
        return ""+id;
    }

}