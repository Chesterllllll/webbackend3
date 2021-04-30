package com.webbackend.webbackend1.repository;

import com.webbackend.webbackend1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
