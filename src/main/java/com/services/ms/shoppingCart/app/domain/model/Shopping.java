package com.services.ms.shoppingCart.app.domain.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shopping {
    private long id;
    private long userId;
    private LocalDateTime date;
    private List<ShoppinItem> items;
    private double totalAmount;
}
