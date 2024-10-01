package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingItemCreateRequest {
    @NotNull(message = "se debe de tener el id del producto")
    private Long productId;

    @NotNull(message = "se debe de tener el nombre de los productos")
    private String productName;

    @NotNull(message = "el precio no puede ser vacio")
    private double price;

    @NotNull(message = "la cantidad no puede ser vacia")
    private int quantity;
}
