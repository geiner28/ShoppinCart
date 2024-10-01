package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

    @NotBlank(message = "el campo name no puede ser nulo o vacio")
    private String name;

@NotNull (message = "el campo stock no puede ser nulo o vacio")
private int stock;

@NotNull(message = "el campo name no puede ser nulo o vacio")
private double price;

    @NotBlank (message = "la descripcion no puede estar vacia ")
    private String description;

    @NotBlank (message ="la imagen no puede estar vacia ")
    private String imageUrl;


}
