package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Group1;

public interface Group1Repository extends JpaRepository<Group1, Long> {
	public Group1 findByEmail(String email);

}
