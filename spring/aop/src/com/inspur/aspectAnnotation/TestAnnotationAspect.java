package com.inspur.aspectAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inspur.dao.UserDao;

public class TestAnnotationAspect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("aspectxml.xml");
		UserDao userDao=(UserDao) context.getBean("userDao");
		userDao.addUser();

	}

}
