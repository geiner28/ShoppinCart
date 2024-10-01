package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper;

import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import com.services.ms.shoppingCart.app.domain.model.Product; // Asegúrate de importar la clase Product
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.ShoppingItemCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.ShoppingItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingItemRestMapper {

    ShoppingItemRestMapper INSTANCE = Mappers.getMapper(ShoppingItemRestMapper.class);

    // Método para mapear manualmente el ShoppingItem
    default ShoppingItem toShoppingItem(ShoppingItemCreateRequest request) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setProduct(mapProduct(request.getProductId())); // Mapea manualmente el Product
        shoppingItem.setProductName(request.getProductName());
        shoppingItem.setPrice(request.getPrice());
        shoppingItem.setQuantity(request.getQuantity());
        return shoppingItem;
    }

    default Product mapProduct(Long productId) {
        Product product = new Product();
        product.setId(productId);
        // Establecer otros atributos del Product si es necesario
        return product;
    }

    ShoppingItemResponse toShoppingItemResponse(ShoppingItemCreateRequest request);

    List<ShoppingItemResponse> toShoppingItemResponses(List<ShoppingItem> items);
}
