package com.webcustomertracker.service.impl;

import com.webcustomertracker.dao.CustomerDAO;
import com.webcustomertracker.model.Customer;
import com.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer deleteCustomer(Customer customer) {
        return customerDAO.deleteCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustoemr(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public Customer updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }
}
