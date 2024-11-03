package com.services.ms.shoppingCart.app.aplication.service;


import com.services.ms.shoppingCart.app.aplication.ports.input.ProductServicePort;
import com.services.ms.shoppingCart.app.aplication.ports.output.ProductPresistence;
import com.services.ms.shoppingCart.app.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {

    private  final ProductPresistence productPresistence;

    @Override
    public Product findProductById(Long id) {
        return productPresistence.findProductById(id).orElseThrow(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return productPresistence.findAllProducts();
    }

    @Override
    public Product saveProduct(Product product) {
        return productPresistence.saveProduct(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productPresistence.findProductById(id).map(saveProduct-> {
        saveProduct.setName(product.getName());
            saveProduct.setStock(product.getStock());
        saveProduct.setPrice(product.getPrice());
        saveProduct.setDescription(product.getDescription());
        saveProduct.setImageUrl(product.getImageUrl());
        return productPresistence.saveProduct(saveProduct);
        })
        .orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        if(productPresistence.findProductById(id).isEmpty()){
            throw new RuntimeException("Product with id " + id + " not found");
        }
productPresistence.deleteProduct(id);
    }
}
