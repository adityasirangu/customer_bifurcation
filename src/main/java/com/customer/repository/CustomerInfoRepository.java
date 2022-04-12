package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.model.CustomerInfo;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
	
	public CustomerInfo findByEmail(String email);
	
	@Query("SELECT cmp FROM CustomerInfo cmp where cmp.address=:address")
	public List<CustomerInfo> group1(@Param("address") String address);
	
	@Query("SELECT cmp FROM CustomerInfo cmp where cmp.address=:address and cmp.Gender=:gender")
	public List<CustomerInfo> group2(@Param("address") String address,@Param("gender") String gender );
	
	@Query("SELECT cmp FROM CustomerInfo cmp where cmp.address=:address and cmp.Gender=:gender")
	public List<CustomerInfo> group3(@Param("address") String address,@Param("gender") String gender );
	

}
