package com.services.ms.shoppingCart.app.domain.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
    private int stock;
    private String description;
    private String imageUrl;

    
}
