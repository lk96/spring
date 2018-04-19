package com.inspur.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.inspur.aspect.MyAspect;

public class CglibProxy implements MethodInterceptor {

	//������
	public Object createProxy(Object target){
		//����һ����̬�����
		Enhancer enhancer=new Enhancer();
		//ȷ��Ҫ��ǿ���࣬��ֵ�丸��
		enhancer.setSuperclass(target.getClass());
		//��ӻص�����
		enhancer.setCallback(this);
		//���ش����Ĵ�����
		return enhancer.create();
	}
	
	/**
	 * arg0 ���ݸ������ɵĴ������
	 * arg1 ���صķ���
	 * arg2 ���ط����Ĳ�������
	 * arg3 �����Ĵ����������ִ�и���ķ���
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		
		//�������������
		MyAspect myAspect=new MyAspect();
		//ǰ��ǿ
		myAspect.check_Permissions();
		//Ŀ��ִ�з���
		Object obj=arg3.invokeSuper(arg0, arg2);
		//����ǿ
		myAspect.log();
		return obj;
	}

}
