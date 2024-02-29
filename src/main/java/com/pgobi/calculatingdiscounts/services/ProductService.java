package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Product;

public interface ProductService {
	Product getProductByUuid(String productUuid);
}
