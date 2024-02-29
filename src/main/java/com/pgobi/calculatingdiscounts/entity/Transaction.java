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
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "discounted_amount")
    private double discountedAmount;

    @Column(name = "original_amount")
    private double originalAmount;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "currency")
    private String currency;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "discount_percentage")
    private double discountPercentage;

    @Column(name = "discount_amount")
    private double discountAmount;

}
