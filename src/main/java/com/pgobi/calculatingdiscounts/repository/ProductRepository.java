package com.pgobi.calculatingdiscounts.repository;

import com.pgobi.calculatingdiscounts.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findProductByProductUuid(String productUuid);
}
