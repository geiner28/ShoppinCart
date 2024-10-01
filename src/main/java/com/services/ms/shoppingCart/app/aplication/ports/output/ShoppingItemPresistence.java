package com.services.ms.shoppingCart.app.aplication.ports.output;

import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;

import java.util.List;
import java.util.Optional;

public interface ShoppingItemPresistence {

    Optional<ShoppingItem> findShoppingItemById(Long id);

    List<ShoppingItem> findAllShoppingItem();

    ShoppingItem saveShoppingItem(ShoppingItem shoppingItem);

    void deleteShoppingItem(Long id);
}
