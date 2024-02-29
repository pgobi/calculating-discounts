package com.pgobi.calculatingdiscounts.services;

import com.pgobi.calculatingdiscounts.entity.Customer;
import com.pgobi.calculatingdiscounts.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findCustomerById(Long id) {
		return customerRepository.findCustomerById(id);
	}

}
