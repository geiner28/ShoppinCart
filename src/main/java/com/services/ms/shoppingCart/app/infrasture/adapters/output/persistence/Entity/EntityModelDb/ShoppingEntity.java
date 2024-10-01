package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping")
public class ShoppingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime date;

    // Cambiado ShoppingItem a ShoppingItemEntity
    @OneToMany(mappedBy = "shopping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingItemEntity> items;

    private double totalAmount;
}
