package com.services.ms.shoppingCart.app.aplication.ports.output;

import com.services.ms.shoppingCart.app.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPresistence {

    Optional<Product> findProductById(Long id);

    List<Product> findAllProducts();

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}
