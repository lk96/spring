package com.inspur.jdk;

public class JdkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����������
		JdkProxy jdkProxy=new JdkProxy();
		//����Ŀ�����
		UserDao userDao=new UserDaoImpl();
		//�Ӵ�������л�ȡ��ǿ���Ŀ�����
		UserDao userDao1=(UserDao) jdkProxy.createProxy(userDao);
		//ִ�з���
		userDao1.addUser();
		userDao1.deleteUser();
	}

}
