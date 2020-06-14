package com.webcustomertracker.service;

import com.webcustomertracker.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
