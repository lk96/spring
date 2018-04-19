package com.inspur.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		check_Permissions();
		Object obj=arg0.proceed();
		log();
		return obj;
	}
	public void check_Permissions(){
		System.out.println("ģ��Ȩ�޼��..");
	}
	public void log(){
		System.out.println("ģ���¼��־..");
	}
}
