package com.webcustomertracker.dao;

import com.webcustomertracker.model.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer deleteCustomer(int id);

    Customer getCustomer(int id);

    Customer updateCustomer(Customer customer);
}
