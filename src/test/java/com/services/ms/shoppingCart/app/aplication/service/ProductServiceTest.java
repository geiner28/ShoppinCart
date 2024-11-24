package com.services.ms.shoppingCart.app.aplication.service;

import com.services.ms.shoppingCart.app.aplication.ports.output.ProductPresistence;
import com.services.ms.shoppingCart.app.domain.model.Product;
import com.services.ms.shoppingCart.app.domain.model.ShoppingItem; // Actualización de la clase importada
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

class ProductServiceTest {

    @Mock
    private ProductPresistence productPresistence;

    @InjectMocks
    private ProductService productService;

    private Product product;



    @BeforeEach
    void setup() {
        product = Product.builder()
                .id(1L)
                .name("Product1")
                .price(10.0)
                .stock(100)
                .description("Description of Product1")
                .imageUrl("http://example.com/image.jpg")
                .build();
    }


    @Test
    void testUpdateProduct_Success() {
        // 1. Preparación: crear un producto actualizado con los nuevos datos
        Product updatedProduct = Product.builder()
                .name("UpdatedProduct")
                .price(15.0)
                .stock(50)
                .description("Updated Description")
                .imageUrl("http://example.com/updated-image.jpg")
                .build();

        // 2. Configuración de mocks
        when(productPresistence.findProductById(1L)).thenReturn(Optional.of(product)); // Simula búsqueda exitosa
        when(productPresistence.saveProduct(any(Product.class))).thenReturn(updatedProduct); // Simula guardado exitoso

        // 3. Ejecución del método bajo prueba
        Product result = productService.updateProduct(1L, updatedProduct);

        // 4. Validaciones
        // Verificar que los valores retornados sean correctos

        assertEquals("UpdatedProduct", result.getName());
        assertEquals(15.0, result.getPrice());
        assertEquals(50, result.getStock());

        // Verificar que los métodos del mock fueron llamados exactamente una vez
        verify(productPresistence, times(1)).findProductById(1L);
        verify(productPresistence, times(1)).saveProduct(any(Product.class));
    }
}