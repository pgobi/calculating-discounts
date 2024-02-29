package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.config.EnvironmentConfig;
import com.pgobi.calculatingdiscounts.entity.Transaction;
import com.pgobi.calculatingdiscounts.model.TransactionResponse;
import com.pgobi.calculatingdiscounts.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

	protected final static Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	CalculatingDiscountsServices calculatingDiscountsServices;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Long addTransaction(int quantity, double amount){
		Transaction transaction = new Transaction();
		LocalDateTime localDateTime = LocalDateTime.now();
		transaction.setCurrency("USD");
		transaction.setQuantity(quantity);
		transaction.setOriginalAmount(amount);
		transaction.setDiscountAmount(calculatingDiscountsServices.getDiscountAmount(quantity));
		transaction.setDiscountedAmount(calculatingDiscountsServices.calculateFinalAmount(quantity,amount));
		transaction.setDiscountPercentage(calculatingDiscountsServices.calculateDiscountPercentage(quantity,amount));
		transaction.setTransactionDate(localDateTime);
		transaction = transactionRepository.saveAndFlush(transaction);
		return transaction.getId();
	}


	@Override
	public List<TransactionResponse> getTransactionsByCustomerId(Long customerId) {
		List<TransactionResponse> transactionResponse = transactionRepository.findTransactionsByCustomerId(customerId);
		return transactionResponse;
	}

}
