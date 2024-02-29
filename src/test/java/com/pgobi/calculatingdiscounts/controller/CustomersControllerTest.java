package com.pgobi.calculatingdiscounts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.pgobi.calculatingdiscounts.entity.Customer;
import com.pgobi.calculatingdiscounts.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CustomersControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomersController customersController;

    @Test
    public void testGetCustomerById() {
        Long customerId = 1L;
        Customer mockCustomer = new Customer();
        mockCustomer.setId(customerId);
        mockCustomer.setFirstName("John");
        mockCustomer.setLastName("Doe");
        when(customerService.findCustomerById(customerId)).thenReturn(mockCustomer);

        ResponseEntity<Object> response = customersController.getCustomerById(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCustomer, response.getBody());
    }
}
