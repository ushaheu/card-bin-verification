package com.digital.bank.verification.controller;

import com.digital.bank.verification.helper.CardVerificationResponse;
import com.digital.bank.verification.service.BinVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ushaheu
 * @date 8/27/20 11:16 AM
 * @project card-bin-verification
 */
@RestController
public class BinVerificationController {

    private BinVerificationService binVerificationService;

    @Autowired
    public BinVerificationController(BinVerificationService binVerificationService) {
        this.binVerificationService = binVerificationService;
    }

    @GetMapping("/card-scheme/verify/{cardBIN}")
    public CardVerificationResponse verifyCardBIN(@PathVariable("cardBIN") Long cardBIN) {
        return binVerificationService.verifyCardBIN(cardBIN);
    }
}
