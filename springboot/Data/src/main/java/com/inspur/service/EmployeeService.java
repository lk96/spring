package com.inspur.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.domain.Employee;
import com.inspur.repository.EmployeeCrudRepository;
import com.inspur.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }
    @Transactional
    public void save(List<Employee> employees) {
    	employeeCrudRepository.save(employees);
    }
    

}
