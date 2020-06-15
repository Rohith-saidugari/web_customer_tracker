package com.webcustomertracker.dao.impl;

import com.webcustomertracker.dao.CustomerDAO;
import com.webcustomertracker.model.Customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer order by lastName");
        List<Customer> result = query.list();
        return result;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        return customer;
    }
}
