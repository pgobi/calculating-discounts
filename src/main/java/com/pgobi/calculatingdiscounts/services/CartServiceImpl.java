package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Cart;
import com.pgobi.calculatingdiscounts.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

	protected final static Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	CartRepository cartRepository;

	@Override
	public Long addNewCart(String cartUuid, String productUuid, int quantity) {
		Cart cart = new Cart();
		LocalDateTime localDateTime = LocalDateTime.now();
		cart.setProductUuid(productUuid);
		cart.setCartUuid(cartUuid);
		cart.setQuantity(quantity);
		cart.setCreatedDate(localDateTime);
		cart = cartRepository.saveAndFlush(cart);
		return cart.getId();
	}


	@Override
	public List <Cart> getCartsByCartUuid(String cartUuid){
		return cartRepository.findCartsByCartUuid(cartUuid);
	}


	@Override
	public List<Cart> updateCartsByCartUuid(String cartUuid, Long orderId) {
		List<Cart> carts = cartRepository.findCartsByCartUuid(cartUuid);
		for (Cart cart : carts) {
			cart.setOrderId(orderId);
		}
		return cartRepository.saveAll(carts);
	}

}
