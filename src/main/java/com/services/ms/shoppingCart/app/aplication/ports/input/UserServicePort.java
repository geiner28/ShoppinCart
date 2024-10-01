package com.services.ms.shoppingCart.app.aplication.ports.input;

import com.services.ms.shoppingCart.app.domain.model.User;

import java.util.List;

public interface UserServicePort {

    User findUserById (Long id);

    List<User> findAllUsers ();

    User saveUser (User user);

    User updateUser (Long id, User user);

    void deleteUser (Long id);

}
