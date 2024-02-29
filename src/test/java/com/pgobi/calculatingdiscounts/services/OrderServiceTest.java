package com.pgobi.calculatingdiscounts.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.pgobi.calculatingdiscounts.entity.Order;
import com.pgobi.calculatingdiscounts.entity.Product;
import com.pgobi.calculatingdiscounts.model.CartRequest;
import com.pgobi.calculatingdiscounts.model.OrderRequest;
import com.pgobi.calculatingdiscounts.model.OrderResponse;
import com.pgobi.calculatingdiscounts.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private TransactionService transactionService;

    @Mock
    private CartService cartService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @Test
    public void testAddOrderAndCartsAndTransaction() {
        Long customerId = 1L;
        List<String> productUuids = Arrays.asList("uuid1", "uuid2");
        List<Integer> quantities = Arrays.asList(2, 3);

        Product product1 = new Product();
        product1.setPrice(10.0);
        when(productService.getProductByUuid("uuid1")).thenReturn(product1);

        Product product2 = new Product();
        product2.setPrice(15.0);
        when(productService.getProductByUuid("uuid2")).thenReturn(product2);

        when(transactionService.addTransaction(anyInt(), anyDouble())).thenReturn(1L);

        Order savedOrder = new Order();
        savedOrder.setId(1L);
        when(orderRepository.saveAndFlush(any(Order.class))).thenReturn(savedOrder);

        OrderRequest orderRequest = new OrderRequest();
        List<CartRequest> carts = new ArrayList<>();
        for (int i = 0; i < productUuids.size(); i++) {
            CartRequest cart = new CartRequest();
            cart.setProductUuid(productUuids.get(i));
            cart.setQuantity(quantities.get(i));
            carts.add(cart);
        }
        orderRequest.setCart(carts);

        OrderResponse orderResponse = orderServiceImpl.addOrderAndCartsAndTransaction(customerId, orderRequest);

        assertNotNull(orderResponse);
        assertEquals(1L, orderResponse.getOrderId());
        assertNotNull(orderResponse.getCartUuid());
    }

    @Test
    public void testGetOrderById() {

        Long orderId = 1L;

        when(orderRepository.findOrderById(orderId)).thenReturn(new Order());

        Order order = orderServiceImpl.getOrderById(orderId);

        assertNotNull(order);
    }

    @Test
    public void testGetOrdersByCustomerId() {

        Long customerId = 1L;

        when(orderRepository.findOrdersByCustomerId(customerId)).thenReturn(Arrays.asList(new Order(), new Order()));

        List<Order> orders = orderServiceImpl.getOrdersByCustomerId(customerId);

        assertNotNull(orders);
        assertEquals(2, orders.size());
    }
}