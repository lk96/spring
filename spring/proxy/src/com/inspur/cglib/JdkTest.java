package com.inspur.cglib;

public class JdkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����������
		CglibProxy cglibProxy=new CglibProxy();
		//����Ŀ�����
		UserDao userDao=new UserDao();
		//�Ӵ�������л�ȡ��ǿ���Ŀ�����
		UserDao userDao1=(UserDao) cglibProxy.createProxy(userDao);
		//ִ�з���
		userDao1.addUser();
		userDao1.deleteUser();
	}

}
