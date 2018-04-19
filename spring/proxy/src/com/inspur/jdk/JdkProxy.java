package com.inspur.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.inspur.aspect.MyAspect;
/**
 * JDK������
 * @author Administrator
 *
 */
public class JdkProxy implements InvocationHandler {
	//����Ŀ����ӿ�
	private UserDao userDao;
	//���������෽��
	public Object createProxy(UserDao userDao){
		this.userDao=userDao;
		//�������
		ClassLoader classLoader=JdkProxy.class.getClassLoader();
		//���������ʵ�ֵ����нӿ�
		Class[] clazz=userDao.getClass().getInterfaces();
		//ʹ�ô����࣬������ǿ�����ص��Ǵ����Ķ���
		return Proxy.newProxyInstance(classLoader, clazz, this);
	}
	/**
	 * ���ж�̬������ķ������ã����ύ��invoke��������ȥ����
	 * proxy �������Ķ���
	 * method ��Ҫ��ִ�еķ�����Ϣ  ����
	 * args ִ�з���ʱ��Ҫ�Ĳ���
	 */
	@Override
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//��������
		MyAspect myAspect=new MyAspect();
		//ǰ��ǿ
		myAspect.check_Permissions();
		//��Ŀ�����ϵ��÷��������������
		Object obj=method.invoke(userDao, args);
		//����ǿ
		myAspect.log();
		return obj;
	}

}
