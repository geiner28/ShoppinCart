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


    @GetMapping("/v1/api/{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        return productRestMapper.toProductResponse(productServicePort.findProductById(id));
    }

    @PostMapping("/v1/api")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRestMapper.toProductResponse(
                        productServicePort.saveProduct(productRestMapper.toProduct(request))
                ));
    }

    @PutMapping("/v1/api/{id}")
    public ProductResponse update (@PathVariable Long id, @Valid @RequestBody ProductCreateRequest request) {
        return productRestMapper.toProductResponse(
                productServicePort.updateProduct(id, productRestMapper.toProduct(request))
        );
    }

    @DeleteMapping("/v1/api/{id}")
    public void delete (@PathVariable Long id) {
        productServicePort.deleteProduct(id);
    }

}
