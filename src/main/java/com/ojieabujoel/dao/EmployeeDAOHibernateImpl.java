package com.ojieabujoel.dao;

import com.ojieabujoel.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query <Employee> theQuery = currentSession.createQuery ("from Employee", Employee.class);
        List <Employee> employees = theQuery.getResultList();
        return employees;
    }

}
