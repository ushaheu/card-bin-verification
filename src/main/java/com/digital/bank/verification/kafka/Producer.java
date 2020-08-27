package com.digital.bank.verification.kafka;

import com.digital.bank.verification.helper.CardVerificationResponse;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * @author ushaheu
 * @date 8/27/20 12:23 PM
 * @project card-bin-verification
 */
public interface Producer {

    @Output("payload")
    MessageChannel sendOut();
}
