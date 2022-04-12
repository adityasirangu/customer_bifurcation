package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerInfo;
import com.customer.repository.CustomerInfoRepository;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	
	@Autowired
	private CustomerInfoRepository infoRepository;

	@Override
	public CustomerInfo save(CustomerDto customerDto) {
		CustomerInfo customerInfo = new CustomerInfo(customerDto.getName(), customerDto.getEmail(),
				customerDto.getContactNumber(), customerDto.getAddress(), customerDto.getPassword(),
				customerDto.getAge(), customerDto.getGender());
		return infoRepository.save(customerInfo);
	}

	@Override
	public Boolean findCustomer(String email) {
		CustomerInfo info=getCustomer(email);
		if(info!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	@Cacheable(value = "customerbif",key = "#email")
	public CustomerInfo getCustomer(String email) {
		
		System.out.println("fetching from db");
		CustomerInfo info=infoRepository.findByEmail(email);
		if(info!=null)
		{
			return info;
		}
		return null;
	}


}
