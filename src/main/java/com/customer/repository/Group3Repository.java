package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Group3;

public interface Group3Repository extends JpaRepository<Group3, Long> {
	public Group3 findByEmail(String email);
}
