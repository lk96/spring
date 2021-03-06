package com.inspur.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inspur.domain.Employee;
import com.inspur.service.EmployeeService;

public class EmployeeCrudRepositoryTest {
	private ApplicationContext ctx = null;
	
    private EmployeeService employeeService = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }
    @Test
    public void testSave() {
    	List<Employee> employees=new ArrayList<Employee>();
    	Employee employee=null;
    	for(int i=0;i<20;i++) {
    		employee=new Employee();
    		employee.setName("test"+i);
    		employee.setAge(100 - i);
    		employees.add(employee);
    	}
    	employeeService.save(employees);
    }

}
