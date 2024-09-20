package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

    @NotBlank(message = "el campo name no puede ser nulo o vacio")
    private String productName;




    @NotBlank (message = "la descripcion no puede estar vacia ")
    private String description;

    @NotBlank (message ="la imagen no puede estar vacia ")
    private String imageUrl;


}
