package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper;

import com.services.ms.shoppingCart.app.domain.model.Shopping;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb.ShoppingEntity;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingPersistenceMapper {

    Shopping toShopping(ShoppingEntity entity);

    ShoppingEntity toShoppingEntity(Shopping shopping);


    
    List<ShoppingEntity> toShoppingEntityList(List<Shopping> shopping) ;

    List<Shopping> toShoppingList(List<ShoppingEntity> entities);


}
