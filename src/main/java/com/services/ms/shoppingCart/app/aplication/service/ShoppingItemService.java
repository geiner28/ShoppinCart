package com.services.ms.shoppingCart.app.aplication.service;

import com.services.ms.shoppingCart.app.aplication.ports.input.ShoppingItemServicePort;
import com.services.ms.shoppingCart.app.aplication.ports.output.ShoppingItemPresistence;
import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShoppingItemService implements ShoppingItemServicePort {

    private final ShoppingItemPresistence shoppingItemPresistence;

    @Override
    public ShoppingItem findShoppingItemById(Long id) {
        return shoppingItemPresistence.findShoppingItemById(id)
            .orElseThrow(() -> new NoSuchElementException("ShoppingItem not found for id: " + id));
    }

    @Override
    public List<ShoppingItem> findAllShoppingItems() {
        return shoppingItemPresistence.findAllShoppingItem();
    }

    @Override
    public ShoppingItem saveShoppingItem(ShoppingItem shoppingItem) {
        return shoppingItemPresistence.saveShoppingItem(shoppingItem);
    }

    @Override
    public ShoppingItem updateShoppingItem(Long id, ShoppingItem shoppingItem) {
        return shoppingItemPresistence.findShoppingItemById(id)
            .map(existingItem -> {
                existingItem.setProductName(shoppingItem.getProductName());
                existingItem.setPrice(shoppingItem.getPrice());
                existingItem.setQuantity(shoppingItem.getQuantity());
                return shoppingItemPresistence.saveShoppingItem(existingItem);
            })
            .orElseThrow(() -> new NoSuchElementException("ShoppingItem not found for id: " + id));
    }

    @Override
    public void deleteShoppingItem(Long id) {
        if (shoppingItemPresistence.findShoppingItemById(id).isEmpty()) {
            throw new RuntimeException("ShoppingItem not found for id: " + id);
        }
        shoppingItemPresistence.deleteShoppingItem(id);
    }
}
