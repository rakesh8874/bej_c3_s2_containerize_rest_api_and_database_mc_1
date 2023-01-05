package com.niit.backendc3_s1_pc_1.repository;

import com.niit.backendc3_s1_pc_1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
