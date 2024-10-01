package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper;

import com.services.ms.shoppingCart.app.domain.model.Shopping;
import com.services.ms.shoppingCart.app.domain.model.User; // Asegúrate de tener esta importación
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.ShoppingCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.ShoppingResponse;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingRestMapper {

    ShoppingRestMapper INSTANCE = Mappers.getMapper(ShoppingRestMapper.class);

    // Método para mapear manualmente el User
    default Shopping toShopping(ShoppingCreateRequest request) {
        Shopping shopping = new Shopping();
        shopping.setUser(mapUser(request.getUserId())); // Mapea manualmente el User
        shopping.setDate(LocalDateTime.now()); // Establece la fecha actual o puedes usar otro valor
        // Aquí puedes establecer otros campos si están disponibles en ShoppingCreateRequest
        return shopping;
    }

    default User mapUser(Long userId) {
        // Lógica para crear y devolver un objeto User usando el userId
        User user = new User();
        user.setId(userId);
        // Establecer otros atributos del User si es necesario
        return user;
    }

    ShoppingResponse toShoppingResponse(Shopping shopping);

    List<ShoppingResponse> toShoppingResponses(List<Shopping> shoppingList);
}
