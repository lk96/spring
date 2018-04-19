package com.inspur.repository;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inspur.domain.Employee;

public class EmployeeJpaRepositoryTest {
	private ApplicationContext ctx = null;
	
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }
    @Test
    public void testFind() {
    	Employee employ=employeeJpaRepository.findOne(40);
    	System.out.println("employ"+employ);
    	System.out.println("employ(10)"+employeeJpaRepository.exists(10));
    	System.out.println("employ(1000)"+employeeJpaRepository.exists(1000));
    
    }

}
