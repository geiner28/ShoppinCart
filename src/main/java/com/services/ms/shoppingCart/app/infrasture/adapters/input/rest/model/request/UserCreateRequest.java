package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    @NotEmpty (message ="el campo name no puede ser vacio o nulo")
    private String name;

    @NotEmpty (message ="el campo surnam no puede ser vacio o nulo")
    private String surname;

    @NotNull (message ="el campo age no puede ser nulo")
    private int age;

    @NotEmpty (message ="el campo DNI no puede ser vacio o nulo")
    private  String DNI;

    @NotEmpty (message ="el campo address no puede ser vacio o nulo")
    private String address;

    @NotEmpty (message ="el campo email no puede ser vacio o nulo")
    private String email;

    @NotEmpty (message ="el campo phne no puede ser vacio o nulo")
    private String phone;

    @NotEmpty (message ="el campo passwor no puede ser vacio o nulo")
    private String password;
}
