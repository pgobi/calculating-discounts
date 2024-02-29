package com.pgobi.calculatingdiscounts.controller;

import com.pgobi.calculatingdiscounts.entity.Product;
import com.pgobi.calculatingdiscounts.enums.ExceptionMessage;
import com.pgobi.calculatingdiscounts.exception.CalculatingDiscountsException;
import com.pgobi.calculatingdiscounts.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    protected final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{productUuid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTransactionsByCustomerId(@PathVariable("productUuid") String productUuid){

        Product product = new Product();

        try {
            product = productService.getProductByUuid(productUuid);
        }catch (Exception e){
            logger.error("[ReportController][getTransactionsByCustomerId] exception: " + e.getMessage());
            throw new CalculatingDiscountsException(ExceptionMessage.SOMETHING_WENT_WRONG.getValue(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

}
