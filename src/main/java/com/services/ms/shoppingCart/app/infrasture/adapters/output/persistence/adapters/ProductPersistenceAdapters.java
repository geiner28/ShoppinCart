package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.adapters;

import com.services.ms.shoppingCart.app.aplication.ports.output.ProductPresistence;
import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper.ProductPersistenceMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository.ProductRepository;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapters implements ProductPresistence {

    private  final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;
    private final UserRepository userRepository;

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id)
                .map(productPersistenceMapper::toProduct);

    }

    @Override
    public List<Product> findAllProducts() {
        return productPersistenceMapper.toProductList(productRepository.findAll());
    }



    @Override
    public Product saveProduct(Product product) {
        return productPersistenceMapper.toProduct(
                productRepository.save(productPersistenceMapper.toProductEntity(product)));
    }

    @Override
    public void deleteProduct(Long id) {
        userRepository.deleteById(id);
    }
}
