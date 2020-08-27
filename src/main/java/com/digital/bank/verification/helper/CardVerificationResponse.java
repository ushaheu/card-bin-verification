package com.digital.bank.verification.helper;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ushaheu
 * @date 8/27/20 1:54 AM
 * @project card-bin-verification
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@JsonRootName("number")
public class CardVerificationResponse {

    private boolean success;
    private Payload payload;
}
