package com.services.ms.shoppingCart.app.aplication.service;

import com.services.ms.shoppingCart.app.aplication.ports.input.ShoppingServicePort;
import com.services.ms.shoppingCart.app.aplication.ports.output.ProductPresistence;
import com.services.ms.shoppingCart.app.aplication.ports.output.ShoppingPresistence;
import com.services.ms.shoppingCart.app.aplication.ports.output.UserPresistence;
import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.domain.model.Shopping;
import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import com.services.ms.shoppingCart.app.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ShoppingService implements ShoppingServicePort {

    private final ShoppingPresistence shoppingPresistence;
    private final ProductPresistence productPresistence;
    private final UserPresistence userPersistence;

    @Override
    public Shopping findShoppingById(Long id) {
        return shoppingPresistence.findShoppingById(id).orElseThrow(() -> new RuntimeException("Shopping not found"));
    }

    @Override
    public List<Shopping> finallShopping() {
        return shoppingPresistence.findAllShopping();
    }

    @Override
    public Shopping saveShopping(Shopping shopping) {
        // Verificar que el ID del usuario no sea nulo
        if (shopping.getUser() == null || shopping.getUser().getId() == null) {
            throw new RuntimeException("User ID must not be null");
        }

        // Verificar si el usuario existe
        User user = userPersistence.findUserById(shopping.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Asociar el usuario existente a la compra
        shopping.setUser(user);

        // Validar los productos y calcular el monto total
        double totalAmount = 0.0;
        for (ShoppingItem item : shopping.getItems()) {
            Product product = productPresistence.findProductById(item.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());
            }

            product.setStock(product.getStock() - item.getQuantity());
            productPresistence.saveProduct(product);
            totalAmount += product.getPrice() * item.getQuantity();
        }

        shopping.setTotalAmount(totalAmount);
        return shoppingPresistence.saveShopping(shopping);
    }

    @Override
    public Shopping updateShopping(Long id, Shopping shopping) {
        return shoppingPresistence.findShoppingById(id).map(saveShopping->{
        saveShopping.setId(shopping.getId());
        saveShopping.setDate(saveShopping.getDate());
        saveShopping.setItems(shopping.getItems());
        saveShopping.setTotalAmount(shopping.getTotalAmount());

        return shoppingPresistence.saveShopping(saveShopping);
        }).orElse(null);
    }



    @Override
    public void deleteShopping(Long id) {
        if(shoppingPresistence.findShoppingById(id).isEmpty()) {
            throw new RuntimeException("Shopping not found");
        }
shoppingPresistence.deleteShopping(id);
    }
}
