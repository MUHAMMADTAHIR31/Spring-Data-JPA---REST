/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.restcrud.cruddemo.dao;

import com.springboot.restcrud.cruddemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{

    private EntityManager entityManager;
    
    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    
    @Override
    public List<Employee> findAll() {
       
        //create a query 
        Query theQuery = entityManager.createQuery("from Employee");
                
        //execute query and get result
        List<Employee> employees = theQuery.getResultList();
       
        //return the result
        return employees;
        
    }

    @Override
    public Employee findById(int theId) {
        
        //get Employee
        Employee theQuery = entityManager.find(Employee.class, theId);
        
        //return reuslt
        return theQuery;
    }

    @Override
    public void save(Employee theEmployee) {
       
        //save or Update the Emp
        Employee dbEmployee = entityManager.merge(theEmployee);
        
        //update with id  from db.. so we can get generated id for save /update
        dbEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void delete(int theId) {
        
        Query theQuery = entityManager.createQuery("delete Employee where id=:employeeId");
                
        //execute query and get result
        theQuery.setParameter("employeeId", theId);
       
        //return the result
        theQuery.executeUpdate();        
    }
}
