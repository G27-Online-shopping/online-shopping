package com.example.onlineshopping.card.entity;

import com.example.onlineshopping.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cardName;
    private String cardFirstName;
    private String cardLastName;
    private String cardNumber;
    private Integer cardCvv;
    private String cardExpirationDate;
    private String phoneNumber;
    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;
}
