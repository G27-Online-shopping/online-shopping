package com.example.onlineshopping.product.entity;

import com.example.onlineshopping.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "`product`")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id" , nullable = false)
    private UUID id;

    @Column(name = "product_name" , nullable = false)
    private String name;

    @Column(name = "product_price" , nullable = false)
    private Integer price;

    @Column(name = "product_date_of_manufacture" , nullable = false)
    private LocalDateTime dateOfManufacture;

    @Column(name = "product_expiration_date" , nullable = false)
    private LocalDateTime expirationDate;

    @Column(nullable = false)
    private String photo;

    @Column(length = 1000)
    private String description;

//    @ManyToOne(targetEntity = User.class)
//    public User user;

}
