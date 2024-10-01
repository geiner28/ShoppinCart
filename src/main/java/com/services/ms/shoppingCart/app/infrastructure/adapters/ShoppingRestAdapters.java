package com.services.ms.shoppingCart.app.infrastructure.adapters;


import com.services.ms.shoppingCart.app.aplication.ports.input.ShoppingServicePort;
import com.services.ms.shoppingCart.app.domain.model.Shopping;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper.ShoppingRestMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.ShoppingCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.ShoppingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping")
public class ShoppingRestAdapters {

    private final ShoppingServicePort shoppingServicePort;
    private final ShoppingRestMapper shoppingRestMapper;

 @PostMapping("/v1/api")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<ShoppingResponse> save(@Valid @RequestBody ShoppingCreateRequest request) {
    Shopping shopping = shoppingRestMapper.toShopping(request);
    
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(shoppingRestMapper.toShoppingResponse(
                shoppingServicePort.saveShopping(shopping)
            ));
}

    // Manejo de excepciones global (opcional)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
