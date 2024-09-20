package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper;


import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.ProductCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRestMapper {

    Product toProduct (ProductCreateRequest request);

    ProductResponse toProductResponse (Product product);

    List<ProductResponse> toProductResponses (List<Product> productslist);


}
