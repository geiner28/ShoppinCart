package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper;


import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {


    Product toProduct(ProductEntity entity);
    ProductEntity toProductEntity(Product product);

    List<ProductEntity> toProductsEntitylist(List<Product> products);

    List<Product> toProductList(List<ProductEntity> entities);
}
