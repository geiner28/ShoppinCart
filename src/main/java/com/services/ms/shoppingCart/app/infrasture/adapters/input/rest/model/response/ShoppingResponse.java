package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response;


import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import com.services.ms.shoppingCart.app.domain.model.User;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingResponse {

  private Long id;
    private User user;
    private LocalDateTime date;
    @Builder.Default
    private List<ShoppingItem> items = new ArrayList<>(); // Inicializa la lista
    private double totalAmount;
}
