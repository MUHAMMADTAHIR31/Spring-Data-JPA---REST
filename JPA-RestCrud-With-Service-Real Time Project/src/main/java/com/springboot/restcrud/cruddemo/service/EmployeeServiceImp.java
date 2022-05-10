/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.restcrud.cruddemo.service;

import com.springboot.restcrud.cruddemo.dao.EmployeeDAO;
import com.springboot.restcrud.cruddemo.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */
@Service
public class EmployeeServiceImp implements EmployeeService{
    
    private EmployeeDAO theEmployeeDAO;
    
    @Autowired
    public EmployeeServiceImp(@Qualifier("employeeDAOJpaImp")EmployeeDAO theEmployeeDAO){
        this.theEmployeeDAO=theEmployeeDAO;
    }
    
    @Override
    @Transactional
    public List<Employee> findAll() {
        return theEmployeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return theEmployeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        theEmployeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void delete(int theId) {
       theEmployeeDAO.delete(theId);
    }
}
