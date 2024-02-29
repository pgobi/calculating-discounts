package com.pgobi.calculatingdiscounts.model;


import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderRequest {
    private List<CartRequest> cart;
}


