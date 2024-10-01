package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.adapters;

import com.services.ms.shoppingCart.app.aplication.ports.output.ShoppingItemPresistence;
import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper.ShoppingItemPersistenceMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository.ShoppingItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ShoppingItemPersistenceAdapters implements ShoppingItemPresistence
{
    private final ShoppingItemRepository shoppingItemRepository;
    private final ShoppingItemPersistenceMapper shoppingItemPersistenceMapper;

    @Override
    public Optional<ShoppingItem> findShoppingItemById(Long id) {
        return shoppingItemRepository.findById(id)
                .map(shoppingItemPersistenceMapper::toShoppingItem);
    }

    @Override
    public List<ShoppingItem> findAllShoppingItem() {
        return shoppingItemPersistenceMapper.toShoppinItemList(shoppingItemRepository.findAll());
    }

    @Override
    public ShoppingItem saveShoppingItem(ShoppingItem shoppingItem) {
        return shoppingItemPersistenceMapper.toShoppingItem(
                shoppingItemRepository.save(shoppingItemPersistenceMapper.toShoppingItemEntity(shoppingItem)));
    }

    @Override
    public void deleteShoppingItem(Long id) {
shoppingItemRepository.deleteById(id);
    }
}
