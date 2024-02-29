package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Cart;
import com.pgobi.calculatingdiscounts.entity.Order;
import com.pgobi.calculatingdiscounts.entity.Product;
import com.pgobi.calculatingdiscounts.model.CartRequest;
import com.pgobi.calculatingdiscounts.model.OrderRequest;
import com.pgobi.calculatingdiscounts.model.OrderResponse;
import com.pgobi.calculatingdiscounts.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	protected final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	TransactionService transactionService;

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@Override
	public OrderResponse addOrderAndCartsAndTransaction(Long customerId, OrderRequest orderRequest){

		List<String> productUuids = new ArrayList<>();
		List<Integer> quantities = new ArrayList<>();

		for (CartRequest cart : orderRequest.getCart()) {
			productUuids.add(cart.getProductUuid());
			quantities.add(cart.getQuantity());
		}

		OrderResponse orderResponse= new OrderResponse();
		String cartUuid = generateRandomCartUuid();
		double totalAmoun = 0.0;
		int quantity = 0;
		for (int i = 0; i < productUuids.size(); i++) {
			totalAmoun = totalAmoun + calculateTotalPriceByOneProduct(quantities.get(i),getPriceByUuid(productUuids.get(i)));
			quantity = quantity +  quantities.get(i);
			logger.info("[OrderServiceImpl][addOrderAndCartsAndTransaction] amoun:" + totalAmoun + " productUuids: " +productUuids.get(i) + " quantities: "+ quantities.get(i));
			cartService.addNewCart(cartUuid, productUuids.get(i), quantities.get(i));
		}
		Long trnsactionId = transactionService.addTransaction(quantity,totalAmoun);
		Long orderId = addOrder(cartUuid,customerId,trnsactionId);
		logger.debug("[OrderServiceImpl][addOrderAndCartsAndTransaction] orderId: " +  orderId + " trnsactionId:  " + trnsactionId + " cartUuid :" + cartUuid);
		updateCartsByCartUuid(cartUuid, orderId);
		orderResponse.setOrderId(orderId);
		orderResponse.setCartUuid(cartUuid);
		return orderResponse;
	}

	public List<Cart> updateCartsByCartUuid(String cartUuid, Long orderId) {
		return cartService.updateCartsByCartUuid(cartUuid, orderId);
	}

	private double getPriceByUuid(String productUuid){
		Product product = productService.getProductByUuid(productUuid);
		double price = product.getPrice();
		return price;
	}

	private double calculateTotalPriceByOneProduct(int quantity, double amoun){
		double totalPrice = amoun *  quantity;
		return totalPrice;
	}

	private Long addOrder(String cartUuid, Long customerId,Long trnsactionId){
		Order order = new Order();
		LocalDateTime localDateTime = LocalDateTime.now();
		order.setCustomerId(customerId);
		order.setCartUuid(cartUuid);
		order.setTransactionId(trnsactionId);
		order.setOrderDate(localDateTime);
		order = orderRepository.saveAndFlush(order);
		return order.getId();
	}


	@Override
	public Order getOrderById(Long id){
		return orderRepository.findOrderById(id);
	}

	@Override
	public List <Order> getOrdersByCustomerId(Long customerId){
		return orderRepository.findOrdersByCustomerId(customerId);
	}


	public static String generateRandomCartUuid() {
		  	int length = 36;
			String charactersCartRandomKey="abcdefghijklmopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			StringBuilder orderNumber = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				int index = random.nextInt(charactersCartRandomKey.length());
				orderNumber.append(charactersCartRandomKey.charAt(index));
			}
			return orderNumber.toString();
		}

}
