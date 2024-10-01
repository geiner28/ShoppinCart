package com.services.ms.shoppingCart.app.aplication.ports.output;

import com.services.ms.shoppingCart.app.domain.model.Shopping;

import java.util.List;
import java.util.Optional;

public interface ShoppingPresistence {

    Optional<Shopping> findShoppingById(Long id);

    List<Shopping> findAllShopping();

    Shopping saveShopping(Shopping shopping);

    void deleteShopping(Long id);

}
