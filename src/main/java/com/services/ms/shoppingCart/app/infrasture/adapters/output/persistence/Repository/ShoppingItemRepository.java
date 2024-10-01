package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository;



import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb.ShoppingItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItemEntity, Long> {
}
