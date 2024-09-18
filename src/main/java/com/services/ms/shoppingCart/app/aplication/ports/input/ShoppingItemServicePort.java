package com.services.ms.shoppingCart.app.aplication.ports.input;

import com.services.ms.shoppingCart.app.domain.model.ShoppinItem;

import java.util.List;

public interface ShoppingItemServicePort {

    ShoppinItem findShoppingItemById(Long     id);

    List <ShoppinItem> findAllShoppingItems();

    ShoppinItem saveShoppinItem(ShoppinItem shoppinItem);

    ShoppinItem updateShoppinItem(Long id,ShoppinItem shoppinItem);

    void deleteShoppingItem(Long id);

}
