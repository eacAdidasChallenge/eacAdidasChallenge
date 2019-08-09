package com.adidas.challenge.mailer.controllers;

import com.adidas.challenge.mailer.services.MailerService;
import com.adidas.challenge.mailer.domain.MailerRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@Api(value = "Mailer microservice", description = "This API send an email confirmation about the subscription")
@Slf4j
public class MailerController {

    @Autowired
    private MailerService mailerService;
	
	@ApiOperation(
            consumes = "application/json",
            produces = "application/json",
            value = "Send a subscription confirmation by mail",
            notes="Subscription confirmation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 403, message = "Forbidden request."),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    @GetMapping("/send")
    public void sendConfirmation(String email, String firstName, String gender, String dateOfBith, String consent, String idNewsletter) 
    		throws UnsupportedEncodingException, InterruptedException {
		log.info("Data received: " + email +" "+ firstName +" "+ gender +" "+ dateOfBith +" "+ consent +" "+ idNewsletter);
		MailerRequest mailerRequest = new MailerRequest();
			mailerRequest.setEmail(email);
			mailerRequest.setFirstName(firstName);
			mailerRequest.setGender(gender);
			mailerRequest.setDateOfBith(dateOfBith);
			mailerRequest.setConsent(consent);
			mailerRequest.setIdNewsletter(idNewsletter);
        mailerService.sendEmail(mailerRequest);
    }

}