package com.pgobi.calculatingdiscounts.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testOrderCreation() {

        Long id = 1L;
        String cartUuid = "12345";
        Long customerId = 2L;
        Long transactionId = 100L;
        LocalDateTime orderDate = LocalDateTime.now();


        Order order = new Order();
        order.setId(id);
        order.setCartUuid(cartUuid);
        order.setCustomerId(customerId);
        order.setTransactionId(transactionId);
        order.setOrderDate(orderDate);


        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(cartUuid, order.getCartUuid());
        assertEquals(customerId, order.getCustomerId());
        assertEquals(transactionId, order.getTransactionId());
        assertEquals(orderDate, order.getOrderDate());
    }
}