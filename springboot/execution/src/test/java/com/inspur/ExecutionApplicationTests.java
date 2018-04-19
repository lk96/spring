package com.inspur;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inspur.bean.Product;
import com.inspur.log.LogService;
import com.inspur.service.ProductService;
import com.inspur.service.sub.SubService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutionApplicationTests {

	@Autowired
	ProductService productService;

	@Autowired
	SubService subService;

	@Autowired
	LogService logService;

	@Test
	public void test() {
		System.out.println("###begin test###");
		productService.findById(1L);
		productService.findByTwoArgs(1L,"hello");
		productService.getName();
		subService.demo();
		try {
			productService.exDemo();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		logService.log();
		productService.log();
		logService.annoArg(new Product());
	}
}
