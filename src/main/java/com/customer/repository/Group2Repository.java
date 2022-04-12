package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Group2;

public interface Group2Repository extends JpaRepository<Group2, Long> {
	public Group2 findByEmail(String email);
}
