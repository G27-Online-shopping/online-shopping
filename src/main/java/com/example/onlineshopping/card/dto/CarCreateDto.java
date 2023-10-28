package com.example.onlineshopping.card.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarCreateDto {
    private String cardName;
    private String cardFirstName;
    private String cardLastName;
    private String cardNumber;
    private Integer cardCvv;
    private String cardExpirationDate;
    private String phoneNumber;
}
