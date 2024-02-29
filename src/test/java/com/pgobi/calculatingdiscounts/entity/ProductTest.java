package com.pgobi.calculatingdiscounts.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("Example Product");
        product.setCreatedDate(LocalDateTime.now());
        product.setPrice(100.0);
        product.setCurrency("USD");

        assertEquals(1L, product.getId());
        assertEquals("Example Product", product.getProductName());
        assertEquals(100.0, product.getPrice());
        assertEquals("USD", product.getCurrency());
    }
}
