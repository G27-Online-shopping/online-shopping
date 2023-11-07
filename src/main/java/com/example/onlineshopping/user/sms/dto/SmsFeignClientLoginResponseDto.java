package com.example.onlineshopping.user.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor@Data
public class SmsFeignClientLoginResponseDto {
    private String message;
    private SmsFeignClientResponseDataDto data;
    @JsonProperty("token_type")
    private String tokenType;

}
