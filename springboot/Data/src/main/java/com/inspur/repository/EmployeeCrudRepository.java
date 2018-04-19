package com.inspur.repository;

import org.springframework.data.repository.CrudRepository;

import com.inspur.domain.Employee;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
