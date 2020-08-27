package com.digital.bank.verification.service;

import com.digital.bank.verification.binlist.response.BinListResponse;
import com.digital.bank.verification.helper.CardVerificationResponse;
import com.digital.bank.verification.helper.Payload;
import com.digital.bank.verification.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ushaheu
 * @date 8/27/20 1:46 AM
 * @project card-bin-verification
 */
@Service
public class BinVerificationService {

    @Value("${binlist.url}")
    private String binListUrl;

    private final RestTemplate restTemplate;

    private final Producer messageProducer;

    @Autowired
    public BinVerificationService(RestTemplate restTemplate, Producer messageProducer) {
        this.restTemplate = restTemplate;
        this.messageProducer = messageProducer;
    }

    public CardVerificationResponse verifyCardBIN(Long cardBIN) {

        CardVerificationResponse cardVerificationResponse = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept-Version", "3");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<BinListResponse> responseEntity = restTemplate.exchange(binListUrl.concat("/{cardBIN}"), HttpMethod.GET, httpEntity, new ParameterizedTypeReference<BinListResponse>() {
        }, cardBIN);
            BinListResponse binListResponse = responseEntity.getBody();
            cardVerificationResponse = new CardVerificationResponse();
            cardVerificationResponse.setSuccess(true);
            Payload payload = null;
            if(binListResponse != null) {
                payload = new Payload().setBank(binListResponse.getBank().getName())
                        .setScheme(binListResponse.getScheme())
                        .setCardBin(cardBIN)
                        .setType(binListResponse.getType());
                messageProducer.sendOut().send(MessageBuilder.withPayload(payload).build());
            }
            cardVerificationResponse.setPayload(payload);


        return cardVerificationResponse;
    }
}
