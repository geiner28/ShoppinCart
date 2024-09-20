package com.services.ms.shoppingCart.app.aplication.service;

import com.services.ms.shoppingCart.app.aplication.ports.input.UserServicePort;
import com.services.ms.shoppingCart.app.aplication.ports.output.UserPresistence;
import com.services.ms.shoppingCart.app.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
 @RequiredArgsConstructor
public class UserService implements UserServicePort {

  private final UserPresistence userPresistence;

    @Override
    public User findUserById(long id) {
        return  userPresistence.findUserById(id).orElseThrow(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userPresistence.findAllUsers();
    }

    @Override
    public User saveUser(User user) {
        return userPresistence.saveUsers(user);
    }

    @Override
    public User updateUser(long id, User user) {
        return userPresistence.findUserById(id).map(saveUser ->{
            saveUser.setName(user.getName());
            saveUser.setEmail(user.getEmail());
            saveUser.setAge(user.getAge());
            saveUser.setDni(user.getDni());
            saveUser.setAddress(user.getAddress());
            saveUser.setEmail(user.getEmail());
            saveUser.setPhone(user.getPhone());
            saveUser.setPassword(user.getPassword());
return userPresistence.saveUsers(saveUser);
        })
                .orElseThrow();
    }

    @Override
    public void deleteUser(long id) {
        if(userPresistence.findUserById(id).isEmpty()){
            throw new RuntimeException("no such user");
        }
userPresistence.deleteUser(id);
    }
}
