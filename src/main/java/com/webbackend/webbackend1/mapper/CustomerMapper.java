package com.webbackend.webbackend1.mapper;

import com.webbackend.webbackend1.dto.CustomerWithComments;
import com.webbackend.webbackend1.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    List<Customer> findAll();
    int create(Customer customer);
    Customer findById(@Param(value = "id") Long id);
    Customer findByUsername(@Param(value = "username") String username);
    int deleteById(@Param(value = "id") Long id);

    List<CustomerWithComments> findAllWithComments();
    List<CustomerWithComments> findAllWithCommentsV2();
}
