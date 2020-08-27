package com.digital.bank.verification.binlist.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ushaheu
 * @date 8/27/20 1:36 AM
 * @project card-bin-verification
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class BinListResponse {

    @JsonProperty("number")
    private BinNumber binNumber;
    private String scheme;
    private String type;
    private String brand;
    private boolean prepaid;
    private Country country;
    private Bank bank;
}
