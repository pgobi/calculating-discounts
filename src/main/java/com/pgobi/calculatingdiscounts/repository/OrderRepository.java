package com.pgobi.calculatingdiscounts.repository;

import com.pgobi.calculatingdiscounts.entity.Order;
import com.pgobi.calculatingdiscounts.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById(Long id);
    List <Order> findOrdersByCustomerId(Long customerId);
    Optional<Order> findTopByOrderByIdDesc();
}
