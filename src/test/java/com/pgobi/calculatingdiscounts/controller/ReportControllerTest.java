package com.pgobi.calculatingdiscounts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.pgobi.calculatingdiscounts.model.TransactionResponse;
import com.pgobi.calculatingdiscounts.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ReportControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @Test
    public void testGetTransactionsByCustomerIdLastThreeMonths() {
        Long customerId = 1L;
        List<TransactionResponse> mockTransactionRespons = new ArrayList<>();
        when(transactionService.getTransactionsByCustomerId(customerId)).thenReturn(mockTransactionRespons);

        ResponseEntity<Object> response = transactionController.getTransactionsByCustomerId(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTransactionRespons, response.getBody());
    }
}
