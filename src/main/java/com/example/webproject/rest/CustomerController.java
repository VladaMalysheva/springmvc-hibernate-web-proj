package com.example.webproject.rest;

import com.example.webproject.entity.Customer;
import com.example.webproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return service.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        Customer customer = service.getCustomer(id);
        if(customer==null){
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }
        return customer;
    }
}
