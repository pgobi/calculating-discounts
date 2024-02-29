package com.pgobi.calculatingdiscounts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pgobi.calculatingdiscounts.entity.Cart;
import com.pgobi.calculatingdiscounts.services.CartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class CartsControllerTest {

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartsController cartsController;

    @Test
    public void testGetPointsByCartsId() {
        String cartUuid = "6e427e4c-7693-4a2b-b0ee-cb699422e3b6";
        String productUuid = "96f682d6-919c-4291-b049-537f09e4e7d9";

        int quantity = 10;

        List<Cart> mockCarts = new ArrayList<>();
        Cart cart=  new Cart();
        cart.setId(1L);
        cart.setOrderId(1L);
        cart.setProductUuid(productUuid);
        cart.setCartUuid(cartUuid);
        cart.setQuantity(quantity);
        cart.setCreatedDate(LocalDateTime.now());
        mockCarts.add(cart);

        when(cartService.getCartsByCartUuid(cartUuid)).thenReturn(mockCarts);

        ResponseEntity<Object> response = cartsController.getPointsByCartsId(cartUuid);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCarts, response.getBody());
    }
}
