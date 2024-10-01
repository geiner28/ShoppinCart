package com.services.ms.shoppingCart.app.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ShoppinItem {
    private long productId;
    private String productName;
    private double price;
    private int quantity;
}
