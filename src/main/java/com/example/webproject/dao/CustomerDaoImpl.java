package com.example.webproject.dao;

import com.example.webproject.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query= session.createQuery("from Customer order by lastName", Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);


    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer c where c.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
