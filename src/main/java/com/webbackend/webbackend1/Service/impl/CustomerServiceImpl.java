package com.webbackend.webbackend1.Service.impl;

import com.webbackend.webbackend1.Service.CustomerService;
import com.webbackend.webbackend1.entity.SecondCustomer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public SecondCustomer getCustomerById(Integer id){
        return new SecondCustomer("111@126.com","123123",66);
    }
}
