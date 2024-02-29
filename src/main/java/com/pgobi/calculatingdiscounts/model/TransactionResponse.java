package com.pgobi.calculatingdiscounts.model;
import lombok.*;

import javax.persistence.Column;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Long customerId;
    private double totalAmount;
}
