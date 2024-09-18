package com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private String surname;
    private int age;
    private  String DNI;
    private String address;
    private String email;
    private String phone;
    private String password;
}
