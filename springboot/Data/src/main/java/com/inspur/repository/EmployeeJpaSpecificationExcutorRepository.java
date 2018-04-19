package com.inspur.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.inspur.domain.Employee;

public interface EmployeeJpaSpecificationExcutorRepository extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee> {

}
