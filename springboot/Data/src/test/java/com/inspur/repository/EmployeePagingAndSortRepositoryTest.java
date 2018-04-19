package com.inspur.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.inspur.domain.Employee;

public class EmployeePagingAndSortRepositoryTest {
private ApplicationContext ctx = null;
	
    private EmployeePagingAndSortRepository employeePagingAndSortRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortRepository = ctx.getBean(EmployeePagingAndSortRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }
    @Test
    public void testPage() {
    	Pageable pageable=new PageRequest(0,5);
    	Page<Employee> page= employeePagingAndSortRepository.findAll(pageable);
    	System.out.println("查询的总页数"+page.getTotalPages());
    	System.out.println("查询的总记录数"+page.getTotalElements());
    	System.out.println("查询当前第几页"+page.getNumber()+1);
    	System.out.println("查询当前页面集合"+page.getContent());
    	System.out.println("查询页面记录数"+page.getNumberOfElements());
    }

    @Test
    public void testPageSort() {
    	Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
    	Sort sort=new Sort(order);
    	Pageable pageable=new PageRequest(0,5,sort);
    	Page<Employee> page= employeePagingAndSortRepository.findAll(pageable);
    	System.out.println("查询的总页数"+page.getTotalPages());
    	System.out.println("查询的总记录数"+page.getTotalElements());
    	System.out.println("查询当前第几页"+page.getNumber()+1);
    	System.out.println("查询当前页面集合"+page.getContent());
    	System.out.println("查询页面记录数"+page.getNumberOfElements());
    }
}
