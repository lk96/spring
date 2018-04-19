package com.inspur.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao) context.getBean("userDaoProxy");
		userDao.addUser();
		userDao.deleteUser();
	}

}
