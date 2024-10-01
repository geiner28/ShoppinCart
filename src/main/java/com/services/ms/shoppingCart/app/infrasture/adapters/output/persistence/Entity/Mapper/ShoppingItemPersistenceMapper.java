package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper;


import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb.ShoppingItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingItemPersistenceMapper {

    ShoppingItem toShoppingItem(ShoppingItemEntity entity) ;


    ShoppingItemEntity toShoppingItemEntity(ShoppingItem shoppingItem) ;

    List<ShoppingItemEntity> toShoppingItemEntityList(List<ShoppingItem> shoppingItems) ;

    List<ShoppingItem> toShoppinItemList(List<ShoppingItemEntity> entities) ;

}
