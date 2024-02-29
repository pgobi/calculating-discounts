package com.pgobi.calculatingdiscounts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


@Component
public  final class EnvironmentConfig  {

    @Value("${policyDiscountAmount.quantityOfProducts}")
    private String quantityOfProductsForPolicyDiscountAmount;

    @Value("${policyDiscountAmount.valueOfAmmount}")
    private String valueOfAmmountForPolicyDiscountAmount;

    @Value("${policyDiscountPercentage.quantityOfProducts}")
    private String quantityOfProductsForPolicyDiscountPercentage;

    @Value("${policyDiscountPercentage.valueOfPercentage}")
    private String valueOfPercentageForPolicyDiscountPercentage;

    @Value("${defaultCurrency}")
    private String defaultCurrency;

    public int[] getQuantityOfProductsForPolicyDiscountAmount() {
        return Stream.of(quantityOfProductsForPolicyDiscountAmount.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public int[] getValueOfAmmountForPolicyDiscountAmount() {
        return Stream.of(valueOfAmmountForPolicyDiscountAmount.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public int[] getQuantityOfProductsForPolicyDiscountPercentage() {
        return Stream.of(quantityOfProductsForPolicyDiscountPercentage.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public int[] getValueOfPercentageForPolicyDiscountPercentage() {
        return Stream.of(valueOfPercentageForPolicyDiscountPercentage.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }
}
