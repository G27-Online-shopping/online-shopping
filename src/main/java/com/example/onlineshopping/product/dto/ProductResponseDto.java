package com.example.onlineshopping.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private UUID id;
    private String name;
    private Integer price;
    private LocalDateTime dateOfManufacture;
    private LocalDateTime expirationDate;

}
