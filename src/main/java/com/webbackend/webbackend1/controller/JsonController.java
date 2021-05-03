package com.webbackend.webbackend1.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.webbackend.webbackend1.Service.CustomerService;
import com.webbackend.webbackend1.entity.SecondCustomer;
import com.webbackend.webbackend1.entity.Views;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "JsonController")
@RestController
public class JsonController {
    final CustomerService customerService;

    @Autowired
    public JsonController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(description = "一个JSON定制演示API", summary = "返回值为原JSON")
    @PostMapping("/json")
    public SecondCustomer jsonOut(@RequestBody SecondCustomer Customer) throws Exception {
        return Customer;
    }

    @Operation(description = "jsonView demo", summary = "返回public View")
    @GetMapping("/public")
    @JsonView(Views.Public.class)
    public SecondCustomer publicView() {
        return customerService.getCustomerById(1);
    }

    @Operation(description = "jsonView demo", summary = "返回public View")
    @GetMapping("/internal")
    @JsonView(Views.Internal.class)
    public SecondCustomer internalView() throws Exception {
        return customerService.getCustomerById(1);
    }
}
