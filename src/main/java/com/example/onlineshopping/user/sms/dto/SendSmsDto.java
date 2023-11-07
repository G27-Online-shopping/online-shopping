package com.example.onlineshopping.user.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SendSmsDto {
    @JsonProperty("mobile_phone")
    private String phoneNumber;
    private String message;
    private String from;
}
