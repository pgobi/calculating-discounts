package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Transaction;
import com.pgobi.calculatingdiscounts.model.TransactionResponse;

import java.util.List;

public interface TransactionService {
	Long addTransaction(int quantity, double amount);
	List<TransactionResponse> getTransactionsByCustomerId(Long customerId);
}