package com.customer.service;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerInfo;

public interface CustomerInfoService {
	
	public CustomerInfo save(CustomerDto customerDto);
	public Boolean findCustomer(String email);
	public CustomerInfo getCustomer(String email);

}
