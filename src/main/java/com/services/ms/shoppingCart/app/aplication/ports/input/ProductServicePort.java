package com.services.ms.shoppingCart.app.aplication.ports.input;

import com.services.ms.shoppingCart.app.domain.model.Product;

import java.util.List;

public interface ProductServicePort {

    Product findProductById(Long id);

    List<Product> findAllProducts();

    Product saveProduct(Product product);

    Product updateProduct(Long id,Product product);

    void deleteProduct(long id);
}
