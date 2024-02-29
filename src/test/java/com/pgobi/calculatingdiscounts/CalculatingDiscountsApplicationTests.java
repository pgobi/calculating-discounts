package com.pgobi.calculatingdiscounts;

import com.pgobi.calculatingdiscounts.config.EnvironmentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CalculatingDiscountsApplication.class)
@ComponentScan(basePackages = "com.pgobi.calculatingdiscounts")
class CalculatingDiscountsApplicationTests {

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Test
    void contextLoads() {
    }

}
