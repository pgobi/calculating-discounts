package com.pgobi.calculatingdiscounts.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer(1L, "John", "Doe", now, now);

        assertNotNull(customer);
        assertEquals(1L, customer.getId());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals(now, customer.getRegistrationDate());
        assertEquals(now, customer.getUpdateDate());
    }

    @Test
    public void testCustomerSetters() {
        Customer customer = new Customer();
        LocalDateTime now = LocalDateTime.now();

        customer.setId(2L);
        customer.setFirstName("Jane");
        customer.setLastName("Smith");
        customer.setRegistrationDate(now);
        customer.setUpdateDate(now);

        assertEquals(2L, customer.getId());
        assertEquals("Jane", customer.getFirstName());
        assertEquals("Smith", customer.getLastName());
        assertEquals(now, customer.getRegistrationDate());
        assertEquals(now, customer.getUpdateDate());
    }
}
