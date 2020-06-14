package com.webcustomertracker.dao;

import com.webcustomertracker.model.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
