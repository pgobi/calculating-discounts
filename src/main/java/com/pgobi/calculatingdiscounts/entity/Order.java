package com.pgobi.calculatingdiscounts.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cart_uuid")
    private String cartUuid;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;
}



