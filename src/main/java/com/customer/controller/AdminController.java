package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.customer.dto.CustomerDto;
import com.customer.repository.Group1Repository;
import com.customer.repository.Group2Repository;
import com.customer.repository.Group3Repository;

@Controller
public class AdminController {
	
	@Autowired
	private Group1Repository group1Repository;
	
	@Autowired
	private Group2Repository group2Repository;
	
	@Autowired
	private Group3Repository group3Repository;

	// login page
	@GetMapping("/Adminlogin")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("Admin-Page");
		CustomerDto customerDto = new CustomerDto();
		mav.addObject("customer", customerDto);
		return mav;
	}

	@PostMapping("/authAdmin")
	public String AuthEmployee(@ModelAttribute CustomerDto dto) {
		if (dto.getEmail().equals("admin") && dto.getPassword().equals("group1")) {
			return "redirect:/login/group1";
		}
		else if (dto.getEmail().equals("admin") && dto.getPassword().equals("group2")) {
			return "redirect:/login/group2";
		}
		else if (dto.getEmail().equals("admin") && dto.getPassword().equals("group3")) {
			return "redirect:/login/group3";
		}
		return "redirect:/login?error";
	}

	@GetMapping("/login/group1") 
	public ModelAndView getgroup1() {
		  ModelAndView mav = new ModelAndView("group-1");
		  mav.addObject("customers",group1Repository.findAll() );
		  return mav;
		  }
	
	@GetMapping("/login/group2") 
	public ModelAndView getgroup2() {
		  ModelAndView mav = new ModelAndView("group-2");
		  mav.addObject("customers",group2Repository.findAll() );
		  return mav;
		  }
	@GetMapping("/login/group3") 
	public ModelAndView getgroup3() {
		  ModelAndView mav = new ModelAndView("group-3");
		  mav.addObject("customers",group3Repository.findAll() );
		  return mav;
		  }
	
	

}
