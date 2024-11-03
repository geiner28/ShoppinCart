package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response;


import com.services.ms.shoppingCart.app.domain.model.Product;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingItemResponse {


    private Product product;
    private String productName;
    private double price;
    private int quantity;


}
