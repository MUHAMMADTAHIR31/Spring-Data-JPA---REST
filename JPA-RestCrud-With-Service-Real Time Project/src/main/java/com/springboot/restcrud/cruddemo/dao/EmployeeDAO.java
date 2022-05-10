/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.restcrud.cruddemo.dao;

import com.springboot.restcrud.cruddemo.entity.Employee;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface EmployeeDAO {
    
    public List<Employee> findAll();
    
    public Employee findById(int theId);
    
    public void save(Employee theEmployee);
    
    public void delete(int theId);
}
