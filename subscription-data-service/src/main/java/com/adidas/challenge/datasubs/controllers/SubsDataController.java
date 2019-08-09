package com.adidas.challenge.datasubs.controllers;

import com.adidas.challenge.datasubs.domain.Subs;
import com.adidas.challenge.datasubs.services.SubsDataService;
import com.adidas.challenge.datasubs.domain.SubsRequest; 

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

//import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@Api(value = "Datasubs microservice", description = "This API has a CRUD for subscription")
@Slf4j
public class SubsDataController {

    @Autowired
    private SubsDataService subsDataService;
	
	@ApiOperation(
            consumes = "application/json",
            produces = "application/json",
            value = "Add a subscription record to db",
            notes="Add a Subs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 403, message = "Forbidden request."),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    @GetMapping("/add")
    public String addSubs(String email, String firstName, String gender, String dateOfBith, String consent, String idNewsletter) {
		log.info("Data received: " + email +" "+ firstName +" "+ gender +" "+ dateOfBith +" "+ consent +" "+ idNewsletter);
		SubsRequest subsRequest = new SubsRequest();
		subsRequest.setEmail(email);
		subsRequest.setFirstName(firstName);
		subsRequest.setGender(gender);
		subsRequest.setDateOfBith(dateOfBith);
		subsRequest.setConsent(consent);
		subsRequest.setIdNewsletter(idNewsletter);
        return subsDataService.addSubs(subsRequest);
    }

}