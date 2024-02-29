package com.pgobi.calculatingdiscounts.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime registrationDate;
    private LocalDateTime updateDate;
}
