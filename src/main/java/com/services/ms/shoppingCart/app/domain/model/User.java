package com.services.ms.shoppingCart.app.domain.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private  String dni;
    private String address;
    private String email;
    private String phone;
    private String password;
}
