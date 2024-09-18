package com.services.ms.shoppingCart.app.aplication.ports.input;

import com.services.ms.shoppingCart.app.domain.model.User;

import java.util.List;

public interface UserServicePort {

    User findUserById (long id);

    List<User> findAllUsers ();

    User saveUser (User user);

    User updateUser (long id, User user);

    void deleteUser (long id);

}
