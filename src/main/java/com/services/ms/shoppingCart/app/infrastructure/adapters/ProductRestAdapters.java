package com.services.ms.shoppingCart.app.infrastructure.adapters;


import com.services.ms.shoppingCart.app.aplication.ports.input.ProductServicePort;

import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper.ProductRestMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.ProductCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductRestAdapters {

    private final ProductServicePort productServicePort;
    private final ProductRestMapper productRestMapper;


    @GetMapping("/v1/api")
    public List<ProductResponse> findAllProducts() {
        return productRestMapper.toProductResponses(productServicePort.findAllProducts());
    }

    @PostMapping("/v1/api")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRestMapper.toProductResponse(
                        productServicePort.saveProduct(productRestMapper.toProduct(request))
                ));

    }
}
