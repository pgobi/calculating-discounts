package com.pgobi.calculatingdiscounts.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TransactionTest {

    @Test
    public void testTransactionCreation() {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setDiscountedAmount(100.0);
        transaction.setCurrency("USD");
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setDiscountPercentage(10);

        assertEquals(1L, transaction.getId());
        assertEquals(100.0, transaction.getDiscountedAmount());
        assertEquals("USD", transaction.getCurrency());
        assertEquals(10, transaction.getDiscountPercentage());
    }
}
