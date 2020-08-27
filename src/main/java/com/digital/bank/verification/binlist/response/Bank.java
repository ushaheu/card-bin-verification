package com.digital.bank.verification.binlist.response;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ushaheu
 * @date 8/27/20 1:37 AM
 * @project card-bin-verification
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class Bank {

    private String name;
    private String url;
    private String phone;
    private String city;
}
