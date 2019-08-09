package com.adidas.challenge.subscription.exception;

public class SubscriptionException extends Exception {

    private String message;

    public SubscriptionException(String message) {
        this.message = message;
    }

}