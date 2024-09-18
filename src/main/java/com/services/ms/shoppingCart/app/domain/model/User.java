package com.services.ms.shoppingCart.app.domain.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String surname;
    private int age;
    private  String DNI;
    private String address;
    private String email;
    private String phone;
    private String password;
}
