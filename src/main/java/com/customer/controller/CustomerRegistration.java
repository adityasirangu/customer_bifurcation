package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.dto.CustomerDto;
import com.customer.service.CustomerInfoService;

@Controller
@RequestMapping("/customerRegistration")
public class CustomerRegistration {
	
	@Autowired
	private CustomerInfoService infoService;
	
	@ModelAttribute("customer")
	public CustomerDto studentDto()
	{
		return new CustomerDto();
	}
	
	@GetMapping
	public String form()
	{
		return "customer-Registration";
	}
	@PostMapping
	public String addCustomer(@ModelAttribute("customer") CustomerDto dto)
	{
		if(infoService.findCustomer(dto.getEmail()))
		{
			return "redirect:/customerRegistration?error";
		}
		infoService.save(dto);
		return "redirect:/customerRegistration?success";
	}

}
