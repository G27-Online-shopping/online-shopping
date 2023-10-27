package com.example.onlineshopping.product.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDto {

    private String name;
    private Integer price;
    private LocalDateTime dateOfManufacture;
    private LocalDateTime expirationDate;
}
