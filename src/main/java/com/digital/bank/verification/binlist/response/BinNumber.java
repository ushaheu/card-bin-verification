package com.digital.bank.verification.binlist.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ushaheu
 * @date 8/27/20 1:40 AM
 * @project card-bin-verification
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@JsonRootName("number")
public class BinNumber {

    private int length;
    private boolean luhn;
}
