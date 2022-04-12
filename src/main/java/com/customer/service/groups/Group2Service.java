package com.customer.service.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.customer.model.CustomerInfo;
import com.customer.model.Group2;
import com.customer.repository.Group2Repository;

@Service
public class Group2Service implements GroupsService {

	@Autowired
	private Group2Repository  group2Repository;
	@Override
	public void save(CustomerInfo customerInfo) {
		Group2 group2 = new Group2(customerInfo.getName(), customerInfo.getEmail(), customerInfo.getContactNumber(),
				customerInfo.getAddress(), customerInfo.getPassword(), customerInfo.getAge(), customerInfo.getGender());
		group2Repository.save(group2);
		return;
		
	}
	@Override
	public Boolean findCustomer(String email) {
		Group2 group2=getCustomer(email);
		if(group2!=null)
		{
			return true;
		}
		return false;
	}
	@Cacheable(value = "group2",key = "#email")
	public Group2 getCustomer(String email) {
		
		Group2 info=group2Repository.findByEmail(email);
		if(info!=null)
		{
			return info;
		}
		return null;
	}

}
