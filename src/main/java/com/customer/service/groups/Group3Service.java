package com.customer.service.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.customer.model.CustomerInfo;
import com.customer.model.Group3;
import com.customer.repository.Group3Repository;

@Service
public class Group3Service implements GroupsService {

	@Autowired
	private Group3Repository group3Repository;
	@Override
	public void save(CustomerInfo customerInfo) {
		Group3 group3 = new Group3(customerInfo.getName(), customerInfo.getEmail(), customerInfo.getContactNumber(),
				customerInfo.getAddress(), customerInfo.getPassword(), customerInfo.getAge(), customerInfo.getGender());
		group3Repository.save(group3);
		return;
	}
	@Override
	public Boolean findCustomer(String email) {
		Group3 group3=getCustomer(email);
		if(group3!=null)
		{
			return true;
		}
		return false;
	}
	@Cacheable(value = "group3",key = "#email")
	public Group3 getCustomer(String email) {
		
		Group3 info=group3Repository.findByEmail(email);
		if(info!=null)
		{
			return info;
		}
		return null;
	}

}
