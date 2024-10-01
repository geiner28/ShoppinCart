package com.services.ms.shoppingCart.app.domain.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Builder
@Getter
@Setter
@NoArgsConstructor

public class Shopping {
    private Long id;
    private User user;
    private LocalDateTime date;
    @Builder.Default
    private List<ShoppingItem> items = new ArrayList<>(); // Inicializa la lista
    private double totalAmount;

        public Shopping(Long id, User user, LocalDateTime date, List<ShoppingItem> items, double totalAmount) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.items = (items != null) ? items : new ArrayList<>(); // Inicializa si es null
        this.totalAmount = totalAmount;
    }
}
