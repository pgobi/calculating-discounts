package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Customer;


public interface CustomerService {
	Customer findCustomerById(Long id);
}
