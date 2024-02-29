package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.model.TransactionResponse;

import java.util.List;

public interface CalculatingDiscountsServices {
	double getDiscountAmount(int quantity);
	double getDiscountPercentage(int quantity);
	double calculateFinalAmount(int quantity, double amount);
	double calculateDiscountPercentage(int quantity, double amount);
}