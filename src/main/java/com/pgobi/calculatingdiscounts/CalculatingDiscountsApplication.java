package com.pgobi.calculatingdiscounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.pgobi.calculatingdiscounts.entity")
@EnableJpaRepositories(basePackages = "com.pgobi.calculatingdiscounts.repository")
public class CalculatingDiscountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatingDiscountsApplication.class, args);
    }

}
