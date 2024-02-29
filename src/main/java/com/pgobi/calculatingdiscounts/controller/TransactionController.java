package com.pgobi.calculatingdiscounts.controller;

import com.pgobi.calculatingdiscounts.enums.ExceptionMessage;
import com.pgobi.calculatingdiscounts.exception.CalculatingDiscountsException;
import com.pgobi.calculatingdiscounts.model.TransactionResponse;
import com.pgobi.calculatingdiscounts.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    protected final static Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTransactionsByCustomerId(@PathVariable("customerId") Long customerId){

        List<TransactionResponse> transactionRespons;

        try {
            transactionRespons = transactionService.getTransactionsByCustomerId(customerId);
        }catch (Exception e){
            logger.error("[ReportController][getTransactionsByCustomerId] exception: " + e.getMessage());
            throw new CalculatingDiscountsException(ExceptionMessage.SOMETHING_WENT_WRONG.getValue(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(transactionRespons,HttpStatus.OK);
    }

}
