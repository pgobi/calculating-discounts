package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Product;
import com.pgobi.calculatingdiscounts.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductByUuid(String productUuid) {
		return productRepository.findProductByProductUuid(productUuid);
	}

}
