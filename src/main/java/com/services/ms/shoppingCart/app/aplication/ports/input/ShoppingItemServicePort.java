package com.services.ms.shoppingCart.app.aplication.ports.input;

import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;

import java.util.List;

public interface ShoppingItemServicePort {

    ShoppingItem findShoppingItemById(Long productId);

    List <ShoppingItem> findAllShoppingItems();

    ShoppingItem saveShoppingItem(ShoppingItem shoppingItem);

    ShoppingItem updateShoppingItem(Long id, ShoppingItem shoppingItem);

    void deleteShoppingItem(Long id);

}
