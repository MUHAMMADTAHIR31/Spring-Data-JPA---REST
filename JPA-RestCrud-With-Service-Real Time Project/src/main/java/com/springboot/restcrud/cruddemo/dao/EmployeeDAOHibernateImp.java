/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.restcrud.cruddemo.dao;

import com.springboot.restcrud.cruddemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */
@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO{

    //define field for entity Manager
    private EntityManager entityManager;
    
    //set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImp(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    
    @Override
    public List<Employee> findAll() {
        
        //get the curret hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        //create  the query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
        
        //exceute the query
        List<Employee> employees=theQuery.getResultList();
        
        //return reuslt
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        
        //get the curret hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        //create  the query
        Employee theQuery = currentSession.get(Employee.class, theId);
        
        //return reuslt
        return theQuery;
    }

    @Override
    public void save(Employee theEmployee) {
        //get the curret hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
        //save  the employee
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void delete(int theId) {
        
        //get the curret hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        
       //delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        
        theQuery.setParameter("employeeId", theId);
        
        theQuery.executeUpdate();
    }
    
}
