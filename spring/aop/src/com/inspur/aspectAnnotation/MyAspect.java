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
 * �����࣬�ڴ����б�д֪ͨ
 * @author Administrator
 *
 */
@Aspect
@Component
public class MyAspect {
	@Pointcut("execution(* com.inspur.dao.*.*(..))")
	public void myPointCut(){
		
	}
	//ǰ��֪ͨ
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ��ģ��ִ��Ȩ�޼��...");
		System.out.println("Ŀ������:"+joinPoint.getTarget());
		System.out.println("��ֲ����ǿ�����Ŀ�귽����:"+joinPoint.getSignature().getName());
	}
	//����֪ͨ
	@AfterReturning("myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint){
		System.out.println("����֪ͨ��ģ���¼��־...");
		System.out.println("Ŀ������:"+joinPoint.getTarget());
	}
	//����֪ͨ
	@Around("myPointCut()")
	public Object myArround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//��ʼ
		System.out.println("���ƿ�ʼ��ִ��Ŀ�귽��֮ǰ��ģ�⿪������");
		//ִ�е�ǰĿ�귽��
		Object obj=proceedingJoinPoint.proceed();
		//����
		System.out.println("���ƽ�����ִ��Ŀ�귽��֮��ģ��ر�����");
		return obj;
	}
	//�쳣֪ͨ
	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("�쳣֪ͨ��"+e.getMessage());
	}
	//����֪ͨ
	@After("myPointCut()")
	public void myAfter(){
		System.out.println("����֪ͨģ�ⷽ����������ͷ���Դ");
	}
	
}
