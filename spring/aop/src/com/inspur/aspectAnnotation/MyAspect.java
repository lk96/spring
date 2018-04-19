package com.inspur.aspectAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类，在此类中编写通知
 * @author Administrator
 *
 */
@Aspect
@Component
public class MyAspect {
	@Pointcut("execution(* com.inspur.dao.*.*(..))")
	public void myPointCut(){
		
	}
	//前置通知
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("前置通知：模拟执行权限检查...");
		System.out.println("目标类是:"+joinPoint.getTarget());
		System.out.println("被植入增强处理的目标方法是:"+joinPoint.getSignature().getName());
	}
	//后置通知
	@AfterReturning("myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint){
		System.out.println("后置通知：模拟记录日志...");
		System.out.println("目标类是:"+joinPoint.getTarget());
	}
	//环绕通知
	@Around("myPointCut()")
	public Object myArround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//开始
		System.out.println("环绕开始：执行目标方法之前，模拟开启事务");
		//执行当前目标方法
		Object obj=proceedingJoinPoint.proceed();
		//结束
		System.out.println("环绕结束：执行目标方法之后，模拟关闭事务");
		return obj;
	}
	//异常通知
	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("异常通知："+e.getMessage());
	}
	//最终通知
	@After("myPointCut()")
	public void myAfter(){
		System.out.println("最终通知模拟方法结束后的释放资源");
	}
	
}
