package com.maide.reserv.customer;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/reserv/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
//    @GetMapping
//    public String getAllCustomers(){
//        return  "customers";
//    }

    @GetMapping("profile")
    public Customer getProfile(Customer customer){
        return customerService.getProfile(customer.getId());
    }

}
