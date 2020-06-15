package com.webcustomertracker.service;

import com.webcustomertracker.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer deleteCustomer(Customer customer);

    Customer getCustoemr(int id);

    Customer updateCustomer(Customer customer);
}
