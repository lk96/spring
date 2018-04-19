package com.inspur.aspectxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * �����࣬�ڴ����б�д֪ͨ
 * @author Administrator
 *
 */
public class MyAspect {
	//ǰ��֪ͨ
	public void myBefore(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ��ģ��ִ��Ȩ�޼��...");
		System.out.println("Ŀ������:"+joinPoint.getTarget());
		System.out.println("��ֲ����ǿ�����Ŀ�귽����:"+joinPoint.getSignature().getName());
	}
	//����֪ͨ
	public void myAfterReturning(JoinPoint joinPoint){
		System.out.println("����֪ͨ��ģ���¼��־...");
		System.out.println("Ŀ������:"+joinPoint.getTarget());
	}
	//����֪ͨ
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
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("�쳣֪ͨ��"+e.getMessage());
	}
	//����֪ͨ
	public void myAfter(){
		System.out.println("����֪ͨģ�ⷽ����������ͷ���Դ");
	}
	
}
