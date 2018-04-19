package com.inspur.log;

import org.springframework.stereotype.Component;

import com.inspur.anno.AdminOnly;
import com.inspur.bean.Product;


@Component
public class LogService implements Loggable{
    @Override
    @AdminOnly
    public void log() {
        System.out.println("log from LogService");
    }

    public void annoArg(Product product){
        System.out.println("execute log service annoArg");
    }
}
