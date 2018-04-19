package com.inspur;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inspur.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionApplicationTests {

	@Autowired
	DemoService demoService;

	@Test
	public void testWithoutTransaction() {
		demoService.addUser("tom");
	}

}
