package com.inspur.repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.inspur.domain.Employee;


public class EmployeeJpaSpecificationExecutorRepositoryTest {
	private ApplicationContext ctx = null;
	
    private EmployeeJpaSpecificationExcutorRepository employeeJpaSpecificationExcutorRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExcutorRepository = ctx.getBean(EmployeeJpaSpecificationExcutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }
    
    /**
     * 分页
     * 排序
     * 查询条件 年龄>50
     */
    @Test
    public void testQuery() {
    	Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
    	Sort sort=new Sort(order);
    	Pageable pageable=new PageRequest(0,5,sort);
    	
    	Specification<Employee> specification=new Specification<Employee>() {
			/**
			 * root:要查询的类型Employee
			 * query:添加查询条件
			 * CB:构建predicate
			 */
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path path=root.get("age");
				
				return cb.gt(path, 50);
			}
		};
		Page<Employee> page=employeeJpaSpecificationExcutorRepository.findAll(specification,pageable);
    	System.out.println("查询的总页数"+page.getTotalPages());
    	System.out.println("查询的总记录数"+page.getTotalElements());
    	System.out.println("查询当前第几页"+page.getNumber()+1);
    	System.out.println("查询当前页面集合"+page.getContent());
    	System.out.println("查询页面记录数"+page.getNumberOfElements());
    }

}
