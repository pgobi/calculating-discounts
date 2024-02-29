package com.pgobi.calculatingdiscounts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;

import com.pgobi.calculatingdiscounts.entity.Order;
import com.pgobi.calculatingdiscounts.model.OrderRequest;
import com.pgobi.calculatingdiscounts.model.OrderResponse;
import com.pgobi.calculatingdiscounts.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrdersControllerTest {

    private OrderService orderService = mock(OrderService.class);
    private OrdersController ordersController = new OrdersController(orderService);

    @Test
    public void testGetOrderById() {
        Long orderId = 1L;
        Order mockOrder = new Order();
        when(orderService.getOrderById(orderId)).thenReturn(mockOrder);

        ResponseEntity<Object> response = ordersController.getOrderById(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockOrder, response.getBody());
    }

    @Test
    public void testAddOrder() {
        Long customerId = 1L;
        OrderRequest orderRequest = new OrderRequest();
        List<String>  productUuids = Arrays.asList("96f682d6-919c-4291-b049-537f09e4e7d9");
        List<Integer> quantities = Arrays.asList(3);
        OrderResponse mockOrderResponse = new OrderResponse();

        when(orderService.addOrderAndCartsAndTransaction(eq(customerId), eq(orderRequest)))
                .thenReturn(mockOrderResponse);
        ResponseEntity<?> response = ordersController.addOrder(null, customerId, orderRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockOrderResponse, response.getBody());
    }
}