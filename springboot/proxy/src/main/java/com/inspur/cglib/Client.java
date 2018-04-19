package com.inspur.cglib;

import com.inspur.pattern.RealSubject;
import com.inspur.pattern.Subject;

import net.sf.cglib.proxy.Enhancer;


public class Client {

    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
