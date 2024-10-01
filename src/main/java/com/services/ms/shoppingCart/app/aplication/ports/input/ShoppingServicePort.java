package com.services.ms.shoppingCart.app.aplication.ports.input;

import com.services.ms.shoppingCart.app.domain.model.Shopping;

import java.util.List;

public interface ShoppingServicePort {

    Shopping findShoppingById(Long id);

    List<Shopping> finallShopping();

    Shopping saveShopping(Shopping shopping);

    Shopping updateShopping(Long id ,Shopping shopping);

    void deleteShopping(Long id);
}
