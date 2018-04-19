package com.inspur.entity;

import java.util.List;


public class User {
	private String username;
	private String password;
	private List<String> list;
	/**
	 * 使用构造器注入
	 * 提供所有参数的构造方法
	 * @param username
	 * @param password
	 * @param list
	 */
	public User(String username, String password, List<String> list) {
		super();
		this.username = username;
		this.password = password;
		this.list = list;
	}
	/**
	 * 使用设值注入
	 * 提供默认的空参构造方法
	 * 为所有属性提供setter方法
	 */
	public User() {
		super();
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", list=" + list + "]";
	}
	
}
