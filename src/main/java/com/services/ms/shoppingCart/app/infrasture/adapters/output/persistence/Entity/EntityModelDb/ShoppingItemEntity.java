package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_items")
public class ShoppingItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_id", nullable = false)
    private ShoppingEntity shopping;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    private String productName;
    private double price;
    private int quantity;
}

