package com.adidas.challenge.subscription.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class SubscriptionExceptionAdvice {


    @ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleAuthorizationException(Exception ex) {
        log.error("Bad Request with invalid input data: ", ex);
        return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), "Input is invalid");
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleRuntime(RuntimeException ex) {
        log.error("Internal Server Error: ", ex);
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "An error occurred in the server. Please try again.");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleException(Exception ex) {
        log.error("Internal Server Error: ", ex);
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "An error occurred in the server. Please try again.");
    }
}