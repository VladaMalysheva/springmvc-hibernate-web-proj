package com.example.webproject.rest;

import com.example.webproject.entity.Customer;
import com.example.webproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/customers")
    public Customer postCustomer(@RequestBody Customer customer){
        customer.setId(0);
        service.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        service.saveCustomer(customer);
        return customer;
    }
}
