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
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> result = query.list();
        return result;
    }
}
