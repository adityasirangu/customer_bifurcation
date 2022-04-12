package com.customer.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.customer.model.CustomerInfo;
import com.customer.repository.CustomerInfoRepository;
import com.customer.service.groups.Group1Service;
import com.customer.service.groups.Group2Service;
import com.customer.service.groups.Group3Service;

@Component
public class GroupScheduler {

	@Autowired
	private CustomerInfoRepository infoRepository;

	@Autowired
	private Group1Service group1Service;

	@Autowired
	private Group2Service group2Service;

	@Autowired
	private Group3Service group3Service;

	@Scheduled(cron = "0 0 0 * * ?")
	public void updateGroup1() {
		List<CustomerInfo> list = infoRepository.group1("mumbai");
		for (CustomerInfo customer : list) {
			if (group1Service.findCustomer(customer.getEmail())) {
				continue;
			}
			group1Service.save(customer);
		}
		System.out.println(list.size());
	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void updateGroup2() {
		List<CustomerInfo> list = infoRepository.group2("banglore", "Male");

		for (CustomerInfo customer : list) {
			if (group2Service.findCustomer(customer.getEmail())) {
				continue;
			}
			group2Service.save(customer);
		}
		System.out.println(list.size());
	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void updateGroup3() {
		List<CustomerInfo> list = infoRepository.group3("banglore", "Female");

		for (CustomerInfo customer : list) {
			if (group3Service.findCustomer(customer.getEmail())) {
				continue;
			}
			group3Service.save(customer);
		}
		System.out.println(list.size());
	}
	

}
