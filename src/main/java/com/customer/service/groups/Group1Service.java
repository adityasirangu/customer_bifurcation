package com.customer.service.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.customer.model.CustomerInfo;
import com.customer.model.Group1;
import com.customer.repository.Group1Repository;

@Service
public class Group1Service implements GroupsService {

	@Autowired
	private Group1Repository group1Repository;

	@Override
	public void save(CustomerInfo customerInfo) {
		Group1 group1 = new Group1(customerInfo.getName(), customerInfo.getEmail(), customerInfo.getContactNumber(),
				customerInfo.getAddress(), customerInfo.getPassword(), customerInfo.getAge(), customerInfo.getGender());
		group1Repository.save(group1);
		return;
	}

	@Override
	public Boolean findCustomer(String email) {
		Group1 group1=getCustomer(email);
		if(group1!=null)
		{
			return true;
		}
		return false;
		
	}
	@Cacheable(value = "group1",key = "#email")
	public Group1 getCustomer(String email) {
		
		Group1 info=group1Repository.findByEmail(email);
		if(info!=null)
		{
			return info;
		}
		return null;
	}

}
