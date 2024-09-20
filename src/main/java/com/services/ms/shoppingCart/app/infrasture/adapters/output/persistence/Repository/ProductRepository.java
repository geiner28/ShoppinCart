package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository;


import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
