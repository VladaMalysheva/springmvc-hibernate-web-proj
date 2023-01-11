package com.example.webproject.service;

import com.example.webproject.dao.CustomerDAO;
import com.example.webproject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
     private CustomerDAO customerDAO;
    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public void saveCustomer(Customer customer){
        customerDAO.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
