package com.pgobi.calculatingdiscounts.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false, name = "product_uuid")
    private String productUuid;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

}
