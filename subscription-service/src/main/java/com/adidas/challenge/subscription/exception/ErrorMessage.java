package com.adidas.challenge.subscription.exception;

import lombok.Data;

@Data
public class ErrorMessage {

    private String status;
    private String message;

    public ErrorMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
