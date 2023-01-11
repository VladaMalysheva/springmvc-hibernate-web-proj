package com.example.webproject.dao;

import com.example.webproject.entity.Customer;
import com.example.webproject.service.CustomerService;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    void deleteCustomer(int id);
}
