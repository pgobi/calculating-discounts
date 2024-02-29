package com.pgobi.calculatingdiscounts.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import com.pgobi.calculatingdiscounts.entity.Customer;
import com.pgobi.calculatingdiscounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testFindCustomerById() {
        Long customerId = 1L;
        Customer customer = new Customer(customerId, "John", "Doe", LocalDateTime.now(), LocalDateTime.now());

        when(customerRepository.findCustomerById(customerId)).thenReturn(customer);

        Customer foundCustomer = customerService.findCustomerById(customerId);

        assertEquals(customer.getId(), foundCustomer.getId());
        assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
        assertEquals(customer.getLastName(), foundCustomer.getLastName());
        assertEquals(customer.getRegistrationDate(), foundCustomer.getRegistrationDate());
        assertEquals(customer.getUpdateDate(), foundCustomer.getUpdateDate());
    }
}
