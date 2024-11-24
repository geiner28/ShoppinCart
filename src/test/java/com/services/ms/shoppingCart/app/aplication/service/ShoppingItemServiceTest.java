package com.services.ms.shoppingCart.app.aplication.service;

import com.services.ms.shoppingCart.app.aplication.ports.output.ShoppingItemPresistence;
import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.domain.model.Shopping;
import com.services.ms.shoppingCart.app.domain.model.ShoppingItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingItemServiceTest {

    @Mock
    private ShoppingItemPresistence shoppingItemPresistence;

    @InjectMocks
    private ShoppingItemService shoppingItemService;

    private ShoppingItem shoppingItem;

    @BeforeEach
    public void setup() {
        shoppingItem = ShoppingItem.builder()
                .id(1L)
                .product(new Product(1L, "Product1", 10.0, 100, "Description of Product1", "http://example.com/image.jpg"))
                .productName("Product1")
                .price(10.0)
                .quantity(2)
                .shopping(new Shopping(1L, null, null, null, 0.0)) // Ajusta según el constructor
                .build();
    }

    @Test
    public void testUpdateShoppingItem_WhenItemExists() {
        // Configuración: Crear un objeto ShoppingItem con los valores actualizados
        ShoppingItem updatedItem = new ShoppingItem();
        updatedItem.setProductName("UpdatedProduct"); // Establecer el nuevo nombre del producto
        updatedItem.setPrice(20.0);                   // Establecer el nuevo precio
        updatedItem.setQuantity(5);                   // Establecer la nueva cantidad
        // Simulación: Configurar el mock para devolver un elemento existente al buscar por ID
        when(shoppingItemPresistence.findShoppingItemById(1L)).thenReturn(Optional.of(shoppingItem));
        // Simulación: Configurar el mock para simular la persistencia del elemento actualizado
        when(shoppingItemPresistence.saveShoppingItem(shoppingItem)).thenReturn(shoppingItem);
        // Ejecución: Llamar al método que se está probando, pasando el ID y el objeto actualizado
        ShoppingItem result = shoppingItemService.updateShoppingItem(1L, updatedItem);
        // Verificación: Comprobar que los valores actualizados coinciden con los esperados
        assertEquals("UpdatedProduct", result.getProductName()); // Verificar el nombre del producto
        assertEquals(20.0, result.getPrice());                   // Verificar el precio
        assertEquals(5, result.getQuantity());                   // Verificar la cantidad
        // Verificación: Asegurarse de que los métodos del mock se llamaron las veces correctas
        verify(shoppingItemPresistence, times(1)).findShoppingItemById(1L); // Comprobar que se buscó el elemento una vez
        verify(shoppingItemPresistence, times(1)).saveShoppingItem(shoppingItem); // Comprobar que se guardó el elemento una vez
    }


    @Test
    public void testUpdateShoppingItem_WhenItemDoesNotExist() {
        // Configuración: Datos de entrada
        ShoppingItem updatedItem = new ShoppingItem();
        updatedItem.setProductName("NonExistentProduct");
        updatedItem.setPrice(15.0);
        updatedItem.setQuantity(3);
        // Simulación: No se encuentra el ShoppingItem por ID
        when(shoppingItemPresistence.findShoppingItemById(99L)).thenReturn(Optional.empty());
        // Ejecución del método bajo prueba
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> shoppingItemService.updateShoppingItem(99L, updatedItem)
        );
        // Afirmaciones: Verifica el mensaje de excepción
        assertEquals("ShoppingItem not found for id: 99", exception.getMessage());
        // Verificaciones: Se intentó buscar el item por ID y no se llamó al guardado
        verify(shoppingItemPresistence, times(1)).findShoppingItemById(99L);
        verify(shoppingItemPresistence, never()).saveShoppingItem(any(ShoppingItem.class));
    }



    @Test
    public void testUpdateShoppingItem_WhenDataIsValidAndItemExists() {
        // Configuración: Datos válidos
        ShoppingItem updatedItem = new ShoppingItem();
        updatedItem.setProductName("ValidProduct");
        updatedItem.setPrice(50.0);
        updatedItem.setQuantity(10);

        // Simulación: El ShoppingItem existe en la base de datos
        when(shoppingItemPresistence.findShoppingItemById(1L)).thenReturn(Optional.of(shoppingItem));
        when(shoppingItemPresistence.saveShoppingItem(shoppingItem)).thenReturn(shoppingItem);

        // Ejecución del método bajo prueba
        ShoppingItem result = shoppingItemService.updateShoppingItem(1L, updatedItem);

        // Afirmaciones: Verifica que los datos se actualizaron correctamente
        assertEquals("ValidProduct", result.getProductName());
        assertEquals(50.0, result.getPrice());
        assertEquals(10, result.getQuantity());

        // Verificación de interacciones
        verify(shoppingItemPresistence, times(1)).findShoppingItemById(1L);
        verify(shoppingItemPresistence, times(1)).saveShoppingItem(shoppingItem);
    }
}
