package com.pgobi.calculatingdiscounts.model;

import lombok.*;


@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private String cartUuid;
}


