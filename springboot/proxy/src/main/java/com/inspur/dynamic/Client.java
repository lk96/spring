package com.inspur.dynamic;


import java.lang.reflect.Proxy;

import com.inspur.pattern.RealSubject;
import com.inspur.pattern.Subject;

public class Client {

    public static void main(String[] args){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
        subject.hello();
    }
}
