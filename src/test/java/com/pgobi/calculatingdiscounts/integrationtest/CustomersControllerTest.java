package com.pgobi.calculatingdiscounts.integrationtest;

import com.pgobi.calculatingdiscounts.CalculatingDiscountsApplication;
import com.pgobi.calculatingdiscounts.entity.Customer;
import com.pgobi.calculatingdiscounts.repository.CustomerRepository;
import com.pgobi.calculatingdiscounts.services.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = CalculatingDiscountsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application.properties")
public class CustomersControllerTest {

    protected static final String BASE_URL = "/api/v1";

    @LocalServerPort
    private int port;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    private  Long customerId = 1l;

    private URI createServerAddress() throws URISyntaxException {
        return new URI("http://localhost:" + port + BASE_URL+  "/customers/" + customerId);
    }

    @Test
    public void testGetCustomerById() throws Exception {
        // Given
       Customer customer = new Customer(customerId,
                "Olivia", "Boyes",
                LocalDateTime.now(),
                LocalDateTime.now());

       when(customerRepository.findCustomerById(customerId)).thenReturn(customer);

       Customer result = customerService.findCustomerById(customerId);
       assertEquals("Olivia", result.getFirstName());assertEquals("Boyes", result.getLastName());
       ResponseEntity<Customer> response = restTemplate.getForEntity(createServerAddress(), Customer.class);

       Customer customerResponse = response.getBody();
       System.out.println("Customer ID: " + customerResponse.getId());
       System.out.println("First Name: " + customerResponse.getFirstName());
       System.out.println("Last Name: " + customerResponse.getLastName());

       // Then
       assertTrue(response.getStatusCode().is2xxSuccessful());
       assertNotNull(response.getBody());
       assertEquals(customerId, response.getBody().getId());
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
