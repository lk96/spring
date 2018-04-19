package com.inspur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ExecutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExecutionApplication.class, args);
	}
}
