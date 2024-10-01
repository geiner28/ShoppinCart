package com.services.ms.shoppingCart.app.aplication.ports.output;

import com.services.ms.shoppingCart.app.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPresistence {

    Optional<User> findUserById(Long id);

    List<User> findAllUsers();

    User saveUsers(User user);

    void deleteUser(Long id);

}
