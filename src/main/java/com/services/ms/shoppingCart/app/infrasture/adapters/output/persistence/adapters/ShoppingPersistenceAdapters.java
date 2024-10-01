package com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.adapters;

import com.services.ms.shoppingCart.app.aplication.ports.output.ShoppingPresistence;
import com.services.ms.shoppingCart.app.domain.model.Shopping;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Entity.Mapper.ShoppingPersistenceMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.output.persistence.Repository.ShoppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShoppingPersistenceAdapters implements ShoppingPresistence {

    private final ShoppingRepository shoppingRepository;
    private final ShoppingPersistenceMapper shoppingPersistenceMapper;

    @Override
    public Optional<Shopping> findShoppingById(Long id) {
        return Optional.ofNullable(shoppingRepository.findById(id)
                .map(shoppingPersistenceMapper::toShopping)
                .orElseThrow(() -> new RuntimeException("Shopping no encontrado con id: " + id)));
    }

    @Override
    public List<Shopping> findAllShopping() {
        return shoppingPersistenceMapper.toShoppingList(shoppingRepository.findAll());
    }

    @Override
    public Shopping saveShopping(Shopping shopping) {
        // Aquí se asume que shopping nunca es nulo, agregar validación si es necesario
        return shoppingPersistenceMapper.toShopping(
                shoppingRepository.save(shoppingPersistenceMapper.toShoppingEntity(shopping))
        );
    }

    @Override
    public void deleteShopping(Long id) {
        if (!shoppingRepository.existsById(id)) {
            throw new RuntimeException("Shopping no encontrado para eliminar con id: " + id);
        }
        shoppingRepository.deleteById(id);
    }
}
