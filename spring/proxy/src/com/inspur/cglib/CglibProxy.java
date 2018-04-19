package com.inspur.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.inspur.aspect.MyAspect;

public class CglibProxy implements MethodInterceptor {

	//代理方法
	public Object createProxy(Object target){
		//创建一个动态类对象
		Enhancer enhancer=new Enhancer();
		//确定要增强的类，设值其父类
		enhancer.setSuperclass(target.getClass());
		//添加回调函数
		enhancer.setCallback(this);
		//返回创建的代理类
		return enhancer.create();
	}
	
	/**
	 * arg0 根据父类生成的代理对象
	 * arg1 拦截的方法
	 * arg2 拦截方法的参数数组
	 * arg3 方法的代理对象，用于执行父类的方法
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		
		//创建切面类对象
		MyAspect myAspect=new MyAspect();
		//前增强
		myAspect.check_Permissions();
		//目标执行方法
		Object obj=arg3.invokeSuper(arg0, arg2);
		//后增强
		myAspect.log();
		return obj;
	}

}
