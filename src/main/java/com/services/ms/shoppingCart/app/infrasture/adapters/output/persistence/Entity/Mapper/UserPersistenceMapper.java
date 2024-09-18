package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper;

import com.services.ms.shoppingCart.app.domain.model.User;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.UserEntity;

import java.util.List;

public interface UserPersistenceMapper {

    User toUser(UserEntity entity);

    UserEntity toUserEntity(User user);

    List<UserEntity> toUserEntityList(List<User> users);

    List<User> toUserList(List<UserEntity> entities);
}
