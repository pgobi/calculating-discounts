package com.pgobi.calculatingdiscounts.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.pgobi.calculatingdiscounts.entity.Transaction;
import com.pgobi.calculatingdiscounts.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CalculatingDiscountsServices calculatingDiscountsServices;


    @InjectMocks
    private TransactionServiceImpl transactionServiceImpl;

    @Test
    public void testAddTransaction() {
        int quantity = 5;
        double amount = 100.0;

        Transaction transaction = new Transaction();
        transaction.setId(1L);

        when(transactionRepository.saveAndFlush(any(Transaction.class))).thenReturn(transaction);
        when(calculatingDiscountsServices.getDiscountAmount(quantity)).thenReturn(10.0);

        Long transactionId = transactionServiceImpl.addTransaction(quantity, amount);

        assertEquals(1L, transactionId);
    }

}
