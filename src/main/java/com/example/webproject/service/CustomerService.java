package com.example.webproject.service;

import com.example.webproject.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    void deleteCustomer(int id);
}
