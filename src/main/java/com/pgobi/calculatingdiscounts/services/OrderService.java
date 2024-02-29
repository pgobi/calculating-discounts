package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Order;
import com.pgobi.calculatingdiscounts.model.OrderRequest;
import com.pgobi.calculatingdiscounts.model.OrderResponse;

import java.util.List;

public interface OrderService {
	OrderResponse addOrderAndCartsAndTransaction(Long customerId, OrderRequest orderRequest);
	Order getOrderById(Long id);
	List <Order> getOrdersByCustomerId(Long customerId);
}
