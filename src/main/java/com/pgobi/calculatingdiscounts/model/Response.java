package com.pgobi.calculatingdiscounts.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Response {
    private boolean result;
    private String message;
}
