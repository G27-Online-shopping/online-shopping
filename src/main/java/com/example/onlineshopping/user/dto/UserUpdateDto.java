package com.example.onlineshopping.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDto {
    private String oldEmail;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
}
