/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.jpacrud.demo.service;


import com.springboot.jpacrud.demo.dao.EmployeeRepository;
import com.springboot.jpacrud.demo.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class EmployeeServiceImp implements EmployeeService{
    
    private EmployeeRepository theEmployeeRepository;
    
    @Autowired
    public EmployeeServiceImp(EmployeeRepository theEmployeeRepository){
        this.theEmployeeRepository=theEmployeeRepository;
    }
    
    @Override
    public List<Employee> findAll() {
        return theEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        
        Optional<Employee> result = theEmployeeRepository.findById(theId);
        
        Employee theEmployee = null;
        
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id -"+ theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        theEmployeeRepository.save(theEmployee);
    }

    @Override
    public void delete(int theId) {
       theEmployeeRepository.deleteById(theId);
    }
}
