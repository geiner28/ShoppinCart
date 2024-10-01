package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCreateRequest {

    @NotNull(message = "el campo user id no puede estar vacio")
    private Long userId;  // Esta propiedad debe ser reconocida.

    @NotNull(message = "se debe tener una fecha")
    private LocalDateTime date;

    @NotNull(message = "se debe tener una lista de items")
    private List<ShoppingItemCreateRequest> items;

    @NotNull(message = "se debe tener una cantidad de compra ")
    private double totalAmount;
}
