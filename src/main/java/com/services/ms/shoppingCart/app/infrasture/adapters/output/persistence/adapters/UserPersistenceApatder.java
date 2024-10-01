package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.adapters;

import com.services.ms.shoppingCart.app.aplication.ports.output.UserPresistence;
import com.services.ms.shoppingCart.app.domain.model.User;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper.UserPersistenceMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceApatder implements UserPresistence {

    private final UserRepository userRepository;

    private  final UserPersistenceMapper userPersistenceMapper;

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id)
                .map(userPersistenceMapper::toUser);
    }

    @Override
    public List<User> findAllUsers() {
        return userPersistenceMapper.toUserList(userRepository.findAll());
    }

    @Override
    public User saveUsers(User user) {
        return userPersistenceMapper.toUser(
                userRepository.save(userPersistenceMapper.toUserEntity(user)));
    }

    @Override
    public void deleteUser(Long id) {
userRepository.deleteById(id);
    }
}
