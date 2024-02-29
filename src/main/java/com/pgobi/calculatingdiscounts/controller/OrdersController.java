package com.pgobi.calculatingdiscounts.controller;

import com.pgobi.calculatingdiscounts.entity.Order;
import com.pgobi.calculatingdiscounts.model.CartRequest;
import com.pgobi.calculatingdiscounts.model.OrderRequest;
import com.pgobi.calculatingdiscounts.model.OrderResponse;
import com.pgobi.calculatingdiscounts.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final static Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrderById(@PathVariable("orderId") Long id) {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> addOrder(HttpServletRequest request,
                                      @PathVariable("customerId") Long customerId,
                                      @RequestBody OrderRequest orderRequest) {

        OrderResponse orderResponse = orderService.addOrderAndCartsAndTransaction(customerId, orderRequest);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}

