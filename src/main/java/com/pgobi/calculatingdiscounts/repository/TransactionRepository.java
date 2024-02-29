package com.pgobi.calculatingdiscounts.repository;

import com.pgobi.calculatingdiscounts.entity.Transaction;
import com.pgobi.calculatingdiscounts.model.TransactionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT new com.pgobi.calculatingdiscounts.model.TransactionResponse(o.customerId, SUM(t.discountedAmount)) " +
            " FROM Transaction t INNER JOIN Order o ON o.transactionId = t.id " +
            " WHERE o.customerId =?1  GROUP BY o.customerId")
    List<TransactionResponse> findTransactionsByCustomerId(Long customerId);

    Transaction findAllById(Long id);

    Optional<Transaction> findTopByOrderByIdDesc();
}
