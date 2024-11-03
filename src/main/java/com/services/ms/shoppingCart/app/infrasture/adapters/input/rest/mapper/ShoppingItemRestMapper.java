package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper;

import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.ShoppingItemCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.ShoppingItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingItemRestMapper {

    ShoppingItemRestMapper INSTANCE = Mappers.getMapper(ShoppingItemRestMapper.class);

    // Método para mapear ShoppingItemCreateRequest a ShoppingItem manualmente
    default ShoppingItem toShoppingItem(ShoppingItemCreateRequest request) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setProduct(mapProduct(request.getProductId()));
        shoppingItem.setProductName(request.getProductName());
        shoppingItem.setPrice(request.getPrice());
        shoppingItem.setQuantity(request.getQuantity());
        return shoppingItem;
    }

    // Método para mapear ShoppingItem a ShoppingItemResponse manualmente
    default ShoppingItemResponse toShoppingItemResponse(ShoppingItem shoppingItem) {
        ShoppingItemResponse response = new ShoppingItemResponse();
        response.setProductName(shoppingItem.getProductName());
        response.setPrice(shoppingItem.getPrice());
        response.setQuantity(shoppingItem.getQuantity());
        return response;
    }

    default Product mapProduct(Long productId) {
        Product product = new Product();
        product.setId(productId);
        // Puedes establecer otros atributos del Product aquí si es necesario
        return product;
    }

    // Método para mapear una lista de ShoppingItems a una lista de ShoppingItemResponses
    default List<ShoppingItemResponse> toShoppingItemResponses(List<ShoppingItem> items) {
        return items.stream()
                .map(this::toShoppingItemResponse)
                .toList();
    }
}
