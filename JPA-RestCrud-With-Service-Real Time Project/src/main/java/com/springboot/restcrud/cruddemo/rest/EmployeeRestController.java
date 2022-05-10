   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.restcrud.cruddemo.rest;

import com.springboot.restcrud.cruddemo.entity.Employee;
import com.springboot.restcrud.cruddemo.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeService employeeService;
    
    //quick and dirty: inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    
    //expose "/employee" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    
    //add mapping for Gete /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        
        Employee theEmployee = employeeService.findById(employeeId);
        
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }
        return theEmployee;
    }
    
    //add mapping for POST /employees -add new Templete
    @PostMapping("/employees/{employeeId}")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        
        //also just in case they pass in id in JSON .. set id to 0
        
        theEmployee.setId(0);
        
        employeeService.save(theEmployee);
        
        return theEmployee;
    }
    
    //add mapping for Update
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        
        employeeService.save(theEmployee);
        
        return theEmployee;
    }
    
     //add mapping for delete /employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        
        Employee theEmployee = employeeService.findById(employeeId);
        
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }
        
        employeeService.delete(employeeId);
        
        return "Deleted employee Id  - "+employeeId;
    }
    
    
}
