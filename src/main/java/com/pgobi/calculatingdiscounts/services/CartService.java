package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Cart;

import java.util.List;

public interface CartService {
	Long addNewCart(String orderNumber, String productUuid, int quantity);
	List <Cart> getCartsByCartUuid(String cartUuid);
	List<Cart> updateCartsByCartUuid(String cartUuid, Long orderId);
}
