package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {


    private Long id;
    private String name;
    private double price;
    private int stock;
    private String description;
    private String imageUrl;
}
