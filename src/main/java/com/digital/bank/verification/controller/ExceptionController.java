package com.digital.bank.verification.controller;

import com.digital.bank.verification.helper.CardVerificationResponse;
import com.digital.bank.verification.helper.Payload;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

/**
 * @author ushaheu
 * @date 8/27/20 12:06 AM
 * @project card-bin-verification
 */
@ControllerAdvice
public class ExceptionController extends ResponseStatusExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<CardVerificationResponse> httpErrorHandler(HttpClientErrorException e) {
        CardVerificationResponse cardVerificationResponse = new CardVerificationResponse().setSuccess(false)
                .setPayload(new Payload().setType(null).setScheme(null).setBank(null));
        return new ResponseEntity<>(cardVerificationResponse, e.getStatusCode());
    }

}
