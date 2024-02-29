package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.config.EnvironmentConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatingDiscountsServicesTest {

    @Mock
    private CalculatingDiscountsServices calculatingDiscountsServices;

    @Mock
    private EnvironmentConfig environmentConfig;

    @InjectMocks
    private CalculatingDiscountsServicesImpl calculatingDiscountsServicesImpl;


    @Test
    public void testGetDiscountPercentage() {
        int quantity = 22;

        when(environmentConfig.getQuantityOfProductsForPolicyDiscountPercentage()).thenReturn(new int[]{10, 50});
        when(environmentConfig.getValueOfPercentageForPolicyDiscountPercentage()).thenReturn(new int[]{3, 5});

        double discountPercentage = calculatingDiscountsServicesImpl.getDiscountPercentage(quantity);

        assertEquals(3.0, discountPercentage);
    }

    @Test
    public void testCalculateDiscountPercentage() {
        int quantity = 22;
        double amount = 1230.0;
        when(environmentConfig.getQuantityOfProductsForPolicyDiscountPercentage()).thenReturn(new int[]{10, 50});
        when(environmentConfig.getValueOfPercentageForPolicyDiscountPercentage()).thenReturn(new int[]{3, 5});

        double discountPercentage = calculatingDiscountsServicesImpl.calculateDiscountPercentage(quantity, amount);

        assertEquals(36.9, discountPercentage);
    }

    @Test
    public void testGetDiscountAmount() {
        int quantity = 22;
        when(environmentConfig.getQuantityOfProductsForPolicyDiscountAmount()).thenReturn(new int[]{10, 100});
        when(environmentConfig.getValueOfAmmountForPolicyDiscountAmount()).thenReturn(new int[]{2, 5});

        double discountAmount = calculatingDiscountsServicesImpl.getDiscountAmount(quantity);

        assertEquals(2.0, discountAmount);
    }

    @Test
    public void testCalculateFinalAmount() {
        int quantity = 22;
        double amount = 1230.0;
        when(environmentConfig.getQuantityOfProductsForPolicyDiscountAmount()).thenReturn(new int[]{10, 100});
        when(environmentConfig.getValueOfAmmountForPolicyDiscountAmount()).thenReturn(new int[]{2, 5});
        when(environmentConfig.getQuantityOfProductsForPolicyDiscountPercentage()).thenReturn(new int[]{10, 50});
        when(environmentConfig.getValueOfPercentageForPolicyDiscountPercentage()).thenReturn(new int[]{3, 5});

        double finalAmount = calculatingDiscountsServicesImpl.calculateFinalAmount(quantity, amount);

        assertEquals(1191.1, finalAmount);
    }
}