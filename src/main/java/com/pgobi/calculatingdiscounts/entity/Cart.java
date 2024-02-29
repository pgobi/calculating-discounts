package com.pgobi.calculatingdiscounts.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_uuid")
    private String productUuid;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cart_uuid")
    private String cartUuid;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}



