package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


        private String name;
        private double price;
        private int stock;
        private String description;
        private String imageUrl;
}
