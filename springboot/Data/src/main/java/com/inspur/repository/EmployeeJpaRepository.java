package com.inspur.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.domain.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
