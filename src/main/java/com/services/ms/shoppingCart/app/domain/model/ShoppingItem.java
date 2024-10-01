package com.services.ms.shoppingCart.app.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ShoppingItem {

    private Long id;

    private Product product;
    private String productName;
    private double price;
    private int quantity;
    private Shopping shopping;
}
