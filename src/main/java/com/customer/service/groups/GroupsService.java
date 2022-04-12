package com.customer.service.groups;

import com.customer.model.CustomerInfo;

public interface GroupsService {
	 public void save(CustomerInfo customerInfo);
	 public Boolean findCustomer(String email);

}
