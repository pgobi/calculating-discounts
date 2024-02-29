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

@Slf4j
@Service
public class CalculatingDiscountsServicesImpl implements CalculatingDiscountsServices {

	protected final static Logger logger = LoggerFactory.getLogger(CalculatingDiscountsServicesImpl.class);

	@Autowired
	private EnvironmentConfig environmentConfig;

	public double calculateFinalAmount(int quantity, double amount) {
		double discountedAmount = getDiscountAmount(quantity);
		double percentageAmount = calculateDiscountPercentage(quantity, amount);
		logger.debug("[CalculatingDiscountsServicesImpl][calculateFinalAmount] discountedAmount : " + discountedAmount + " percentageAmount:" +percentageAmount);
		return amount - discountedAmount - percentageAmount;
	}

	public double getDiscountAmount(int quantity) {
		double discountAmount = 0;
		for (int i = 0; i < environmentConfig.getQuantityOfProductsForPolicyDiscountAmount().length; i++) {
			if (quantity >= environmentConfig.getQuantityOfProductsForPolicyDiscountAmount()[i]) {
				discountAmount = environmentConfig.getValueOfAmmountForPolicyDiscountAmount()[i];
				BigDecimal bd = new BigDecimal(Double.toString(discountAmount));
				bd = bd.setScale(2, RoundingMode.HALF_UP);
				discountAmount = bd.doubleValue();
			}
		}
		return discountAmount;
	}

	public double getDiscountPercentage(int quantity) {
		double percentage = 0;
		for (int i = 0; i < environmentConfig.getQuantityOfProductsForPolicyDiscountPercentage().length; i++) {
			int quantityOfProducts = environmentConfig.getQuantityOfProductsForPolicyDiscountPercentage()[i];
			if (quantity >= quantityOfProducts) {
				percentage = environmentConfig.getValueOfPercentageForPolicyDiscountPercentage()[i];
			}
		}
		return percentage;
	}

	public double calculateDiscountPercentage(int quantity, double amount) {
		double discountPercentage = (getDiscountPercentage(quantity) / 100) * amount;
		BigDecimal bd = new BigDecimal(Double.toString(discountPercentage));
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
