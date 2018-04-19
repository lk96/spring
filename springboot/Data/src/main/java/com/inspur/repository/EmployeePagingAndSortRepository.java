package com.inspur.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.inspur.domain.Employee;

public interface EmployeePagingAndSortRepository extends PagingAndSortingRepository<Employee, Integer>{

}
