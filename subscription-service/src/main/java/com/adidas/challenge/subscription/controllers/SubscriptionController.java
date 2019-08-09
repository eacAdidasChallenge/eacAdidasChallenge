package com.adidas.challenge.subscription.controllers;

import com.adidas.challenge.subscription.domain.SubscriptionRequest;
import com.adidas.challenge.subscription.domain.response.SubscriptionResponse;

import com.adidas.challenge.subscription.services.SubscriptionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @ApiOperation(
            consumes = "application/json",
            produces = "application/json",
            value = "Operate and return a table ID for a subscription",
            notes="Subscription operations returning ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operations successful"),
            @ApiResponse(code = 403, message = "Forbidden request."),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    @PostMapping("/new")
    public SubscriptionResponse operateWithIdReturn(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.operateWithIdReturn(subscriptionRequest);
    }
}