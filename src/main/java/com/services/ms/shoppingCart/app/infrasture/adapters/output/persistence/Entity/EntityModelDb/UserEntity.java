    package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.EntityModelDb;


    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "users")
    public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String surname;

        private int age;

        @Column(nullable = false, unique = true)
        private String dni;

        private String address;

        @Column(nullable = false, unique = true)
        private String email;

        private String phone;

        @Column(nullable = false)
        private String password;


    }

